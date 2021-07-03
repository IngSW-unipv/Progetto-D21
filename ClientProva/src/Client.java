import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Client {
    private Socket mySocket = null;
    private DataInputStream in;
    private DataOutputStream out;
    private int port = 6789;

    public Socket connect() {
        //socket tra client e server
        try {
            System.out.println("[0] - Trying Connection to Server...");
            mySocket = new Socket(InetAddress.getLocalHost(),port);
            System.out.println("[1] - Connected!");
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mySocket;
    }
}
