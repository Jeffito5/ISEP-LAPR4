package eapli.base.servermanagement;

import eapli.base.agvmanagement.mapper.dto.AGVDTO;
import eapli.base.warehousemanagement.mappers.dtos.AisleDTO;
import eapli.base.warehousemanagement.mappers.dtos.DockDTO;
import eapli.base.warehousemanagement.mappers.dtos.PlantDTO;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 1201180 - Guilherme Sencadas
 * @author 1201228 - Ana Silva
 */
public class Server extends Thread {

    static private final String BASE_FOLDER = "www";
    static private final String PASSWORD = "Password1";
    static private final String KEYSTORE = "server_web.jks";
    static private final ServerController controller = new ServerController();

    static private SSLServerSocket sock;
    private final String[] args;

    public Server(String[] args) {
        this.args = args;
    }

    /**
     * Gets the available Ip Addresses to connect to the server
     *
     * @return List with each Ip Address
     * @throws SocketException Thrown by NetworkInterface.getNetworkInterfaces()
     */
    public static List<String> getIpAddress() throws SocketException {
        List<String> ips = new ArrayList<>();
        var allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip;
        while (allNetInterfaces.hasMoreElements()) {
            var netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            var addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    ips.add(ip.getHostAddress());
                }
            }
        }
        return ips;
    }

    public void run() {
        try {
            SSLSocket clientSocket;
            if (args.length != 1) {
                System.out.println("Local port number required at the command line.");
                System.exit(1);
            }

            System.setProperty("javax.net.ssl.keyStore", KEYSTORE);
            System.setProperty("javax.net.ssl.keyStorePassword", PASSWORD);

            try {
                if (!Files.exists(Path.of(KEYSTORE))) {
                    throw new IllegalArgumentException("File " + KEYSTORE + " not found.");
                }

                SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                sock = (SSLServerSocket) sslF.createServerSocket(Integer.parseInt(args[0]));
            } catch (IOException ex) {
                System.out.println("Server failed to open local port " + args[0]);
                System.exit(1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            while (true) {
                clientSocket = (SSLSocket) sock.accept();
                HttpAjaxRequest request = new HttpAjaxRequest(clientSocket, BASE_FOLDER);
                request.start();
                incAccessesCounter();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static int accessesCounter;
    private static final String STYLE_WAREHOUSEPLANT = "warehousePlant";
    private static final String STYLE_PLANTBLOCK = "plantBlock";
    private static final String STYLE_PLANTAISLE = "plantAisle";
    private static final String STYLE_PLANTDOCK = "plantDock";
    private static final String STYLE_PLANTAGV = "plantAGV";

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

    /**
     * Displays the AGV Information in HTML code format.
     *
     * @return String with HTML code.
     */
    public static String getAgvInfo() {
        List<AGVDTO> agvList = getAGVs();
        StringBuilder sb = new StringBuilder();
        sb.append("<table><tr> <th>Identifier</th> <th>Status</th> <th>Autonomy</th> <th>Position</th> </tr>");
        for (AGVDTO agv : agvList) {
            sb.append("<tr><td>").append(agv.identifier.identifier()).append("</td><td>").append(agv.status).append("</td><td>").append(agv.autonomy).append("</td>");
            if (agv.coordinates == null) {
                sb.append("<td>Docked</td>");

            } else
                sb.append("<td>").append(agv.coordinates.length()).append(" x ").append(agv.coordinates.width()).append("</td>");

            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</ul><hr><p>HTTP server accesses counter: ").append(accessesCounter).append("</p><hr>");
        return sb.toString();
    }

    /**Displays the in HTML code to change window.
     *
     * @return String with HTML code.
     */
    public static String changeScreenHTML() {
        return " <meta http-equiv = \"refresh\" content = \"2; url = WarehouseInfo.html\" />";
    }

    /**
     * Displays the Plant Information in HTML code format.
     *
     * @return String with HTML code.
     */
    public static String getPlantInfo() {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        try {
            PlantDTO plantDTO = getPlant();
            int length = (int) (plantDTO.length / plantDTO.square);
            int width = (int) (plantDTO.width / plantDTO.square);

            sb.append("<div class = ").append(STYLE_WAREHOUSEPLANT).append(" style=\"grid-template-columns: repeat(").append(length).append(",40px); grid-template-rows: repeat(").append(width).append(",40px);\">\n");

            List<DockDTO> dockDTOS = getDocks();
            for (DockDTO dto : dockDTOS) {
                int beginLength = (int) dto.begin_lenght;
                int endLength = (int) dto.end_lenght;
                int beginWidth = (int) dto.begin_width;
                int endWidth = (int) dto.end_width;
                sb.append("<div class=").append(STYLE_PLANTDOCK).append(" style=\"grid-column: ").append(beginLength).append("/").append(endLength).append(";grid-row: ").append(beginWidth).append("/").append(endWidth).append("\"></div>\n");

                int sumLength = endLength - beginLength;
                if (sumLength == 0)
                    sumLength = 1;


                int sumWidth = endWidth - beginWidth;
                if (sumWidth == 0)
                    sumWidth = 1;

                num += sumLength * sumWidth;
            }


            List<AisleDTO> aisleDTOS = getAisles();
            for (AisleDTO dto : aisleDTOS) {
                int beginLength = (int) dto.begin.length();
                int endLength = (int) dto.end.length();
                int beginWidth = (int) dto.begin.width();
                int endWidth = (int) dto.end.width();
                sb.append("<div class=").append(STYLE_PLANTAISLE).append(" style=\"grid-column: ").append(beginLength).append("/").append(endLength).append(";grid-row: ").append(beginWidth).append("/").append(endWidth).append("\"></div>\n");

                int sumLength = endLength - beginLength;
                if (sumLength == 0)
                    sumLength = 1;

                int sumWidth = endWidth - beginWidth;
                if (sumWidth == 0)
                    sumWidth = 1;
                num += sumLength * sumWidth;
            }

            List<AGVDTO> agvdtos = getAGVs();
            for (AGVDTO dto : agvdtos) {
                if (dto.coordinates != null) {
                    int beginLength = (int) dto.coordinates.length();
                    int beginWidth = (int) dto.coordinates.width();

                    sb.append("<div class=").append(STYLE_PLANTAGV).append(" style=\"grid-column: ").append(beginLength).append(";grid-row: ").append(beginWidth).append("\"></div>\n");
                    num++;
                }
            }

            for (int i = 0; i < (length * width) - num; i++) {
                sb.append("<div class=").append(STYLE_PLANTBLOCK).append("></div>\n");
            }
            sb.append("</div>");

        } catch (Exception e) {
            sb = new StringBuilder();
            sb.append("Error Loading Information");
        }
        return sb.toString();
    }

    public static synchronized List<AGVDTO> getAGVs() {
        return controller.getAgvsDTO();
    }

    public static synchronized List<DockDTO> getDocks() {
        return controller.getDocks();
    }

    public static synchronized List<AisleDTO> getAisles() {
        return controller.getAisles();
    }

    public static synchronized PlantDTO getPlant() {
        return controller.getPlants().get(0);
    }

    public static synchronized boolean doLogin(String username, String password) {
        return controller.doLogin(username, password);
    }
}
