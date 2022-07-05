package eapli.base.servermanagement;

import java.io.*;

/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */

public class HTTPMessage {

    //CR + LF sequence is used in HTTP to mark the end of each header's line
    private static final int CR = 13;
    private static final int LF = 10;

    private static final String VERSION = "HTTP/1.1";

    private static final String CONTENT_TYPE = "Content-type:";
    private static final String CONTENT_LENGTH = "Content-length:";
    private static final String CONNECTION = "Connection:";

    private static final String[][] knownFileExt = {
            {".pdf", "application/pdf"},
            {".js", "application/javascript"},
            {".txt", "text/plain"},
            {".gif", "image/gif"},
            {".png", "image/png"}
    };

    /**
     * Reads the Header's Line
     * <p>
     * Iterates through the DataInputStream reading one value at a time.<br>
     * When the DataInputStream returns CR, then afterwards is the end of the header, LF
     *
     * </p>
     *
     * @param in Socket's DataInputStream that allows us to read the header
     * @return Text within the header
     * @throws IOException Thrown by DataInputStream
     */
    static private String readHeaderLine(DataInputStream in) throws IOException {
        String result = "";
        int value;
        do {
            value = in.read();
            if (value == -1) throw new IOException();
            if (value != CR) result = result + (char) value;
        }
        while (value != CR);
        value = in.read(); // read LF
        if (value == -1) throw new IOException();
        return result;
    }

    /**
     * Used to send the message from the Client to the Server.
     *
     * @param out  Socket's DataOutputStream to write into.
     * @param line String with the information we want to write.
     * @throws IOException Thrown by DataOutputStream.
     */
    static private void writeHeaderLine(DataOutputStream out, String line) throws IOException {
        out.write(line.getBytes(), 0, line.length());
        out.write(CR);
        out.write(LF);
    }


    //// NON-STATIC (INSTANCE) ELEMENTS

    private boolean isRequest;
    private String method;
    private String uri;
    private String status;

    private String contentType;
    private byte[] content;


    /**
     * Constructor to read the HTTP Response
     *
     * @param input DataInputStream with the Header
     * @throws IOException Thrown by DataInputStream
     */
    public HTTPMessage(DataInputStream input) throws IOException {
        String firstLine = readHeaderLine(input);
        isRequest = !firstLine.startsWith("HTTP/"); //When the message starts with 'HTTP/' (Status Line) is a Response Message
        method = null;
        uri = null;
        content = null;
        status = null;
        contentType = null;

        String[] firstLineComp = firstLine.split(" ");
        if (isRequest) {
            method = firstLineComp[0];
            uri = firstLineComp[1];
        } else {
            status = firstLineComp[1] + " " + firstLineComp[2];   //200 OK
        }

        String headerLine;

        do {
            headerLine = readHeaderLine(input);
            if (headerLine.toUpperCase().startsWith(CONTENT_TYPE.toUpperCase())) {
                contentType = headerLine.substring(CONTENT_TYPE.length()).trim();
            } else {
                if (headerLine.toUpperCase().startsWith(CONTENT_LENGTH.toUpperCase())) {
                    String contentLength = headerLine.substring(CONTENT_LENGTH.length()).trim();
                    int length;
                    try {
                        length = Integer.parseInt(contentLength);
                    } catch (NumberFormatException exception) {
                        throw new IOException();
                    }
                    content = new byte[length];
                }
            }
        } while (!headerLine.isEmpty());

        //READ CONTENT
        if (content != null)
            input.readFully(content, 0, content.length);
    }

    /**
     * First connection, results in an HTTP Request
     */
    public HTTPMessage() {
        isRequest = true;
        method = null;
        uri = null;
        content = null;
        status = null;
        contentType = null;
    }

    public void setResponseStatus(String status) {
        isRequest = false;
        this.status = status;
    }

    public void setContent(String cnt, String cType) {
        content = cnt.getBytes();
        contentType = cType;
    }

    public void setRequestMethod(String m) {
        isRequest = true;
        method = m;
    }

    public boolean send(DataOutputStream output) throws IOException {
        if (isRequest) {
            if (method == null || uri == null)
                return false;
            writeHeaderLine(output, method + " " + uri + " " + VERSION);    //Request Line
        } else {
            if (status == null)
                return false;
            writeHeaderLine(output, VERSION + " " + status);     //Status Line
        }

        if (content != null) {
            if (contentType != null) {
                writeHeaderLine(output, CONTENT_TYPE + " " + contentType);  //Entity Headers
            }
            writeHeaderLine(output, CONTENT_LENGTH + " " + content.length);
        }
        writeHeaderLine(output, CONNECTION + " close");      //General Header
        writeHeaderLine(output, "");                         //Empty Line

        if (content != null) {
            output.write(content, 0, content.length);  //Message Body
        }
        return true;
    }

    public String getMethod() {
        return method;
    }

    public String getURI() {
        return uri;
    }

    public String getStatus() {
        return status;
    }

    public void setURI(String u) {
        uri = u;
    }


    public boolean hasContent() {
        return (content != null);
    }

    public String getContentAsString() {
        return (new String(content));
    }

    public byte[] getContent() {
        return (content);
    }

    public void setContentFromString(String c, String ct) {
        content = c.getBytes();
        contentType = ct;
    }

    public boolean setContentFromFile(String fname) {
        File file = new File(fname);
        contentType = null;
        if (!file.exists()) {
            content = null;
            return false;
        }

        for (String[] k : knownFileExt) {
            if (fname.endsWith(k[0]))
                contentType = k[1];
        }
        if (contentType == null)
            contentType = "text/html";

        int contentLength = (int) file.length();
        if (contentLength == 0) {
            content = null;
            contentType = null;
            return false;
        }
        content = new byte[contentLength];

        DataInputStream fr;
        try {
            fr = new DataInputStream(new FileInputStream(file));
            try {
                fr.readFully(content, 0, contentLength);
                fr.close();
            } catch (IOException exception) {
                System.out.println("Error reading file");
                content = null;
                contentType = null;
                return false;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not Found");
            content = null;
            contentType = null;
            return false;
        }
        return true;
    }
}
