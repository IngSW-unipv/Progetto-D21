import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket socketClient = null;
    private DataOutputStream out;
    private DataInputStream in;
    private int port = 6789; //porta server

    public Socket waitFor(){
        try {
            System.out.println("[0] - Server Init...");
            //init service
            serverSocket = new ServerSocket(port);

            System.out.println("[1] - Server Ready, listening on: "+port);
            //waiting for connection
            socketClient = serverSocket.accept();
            System.out.println("[2] - Connection Established!");

            //avoiding multiple connections
            serverSocket.close();
            //where client is writing

            in = new DataInputStream(socketClient.getInputStream());
            //where we tell client
            out = new DataOutputStream(socketClient.getOutputStream());
        } catch (IOException e) {

        }
        return socketClient;
    }

}
