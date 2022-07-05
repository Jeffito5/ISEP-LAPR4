package eapli.base.servermanagement;

import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HttpAjaxRequest extends Thread {

    String baseFolder;
    SSLSocket sock;
    DataInputStream inS;
    DataOutputStream outS;

    public HttpAjaxRequest(SSLSocket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
        }

        try {
            HTTPMessage request = new HTTPMessage(inS);
            HTTPMessage response = new HTTPMessage();

            if (request.getMethod().equals("GET")) {
                if (!request.getURI().startsWith("/login/")) {

                    switch (request.getURI()) {
                        case "/agvs":
                            response.setContentFromString(Server.getAgvInfo(), "text/html");
                            break;

                        case "/plant":
                            response.setContentFromString(Server.getPlantInfo(), "text/html");
                            break;

                        default:
                            String fullname = baseFolder + "/";
                            if (request.getURI().equals("/")) fullname = fullname + "index.html";
                            else fullname = fullname + request.getURI();
                            if (response.setContentFromFile(fullname)) {
                                response.setResponseStatus("200 Ok");
                            } else {
                                response.setContentFromString(
                                        "<html><body><h1>404 File not found</h1></body></html>",
                                        "text/html");
                                response.setResponseStatus("404 Not Found");
                                break;
                            }
                    }
                } else {
                    String[] arr = request.getURI().substring("/login/".length()).split("-");
                    if (Server.doLogin(arr[0], arr[1])) {
                        response.setContentFromString(Server.changeScreenHTML(), "text/html");
                    } else {
                        response.setContentFromString("Error login in.", "text/html");
                    }

                }

                response.setResponseStatus("200 Ok");
                response.send(outS);
            } else { // NOT GET
                response.setContentFromString(
                        "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                        "text/html");
                response.setResponseStatus("405 Method Not Allowed");

                response.send(outS);
            }
        } catch (IOException ex) {
            //System.out.println("Thread error when reading request");
        }

        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }
}