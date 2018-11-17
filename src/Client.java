import java.io.*;
import java.net.*;
public class Client {
    public static void main(String args[ ])
            throws IOException {
        String serverName = "localhost"; //or remote IP Address
        int port = 1234; // should be same as used in server
        /* Connect to server that is already listening */
        Socket server = new Socket(serverName, port);
        System.out.println("Just connected to " +
                server.getRemoteSocketAddress());
        DataInputStream in = new
                DataInputStream(server.getInputStream());
        System.out.println("Server says " + in.readUTF());
        in.close();
        /* close connection with server */
        server.close();
    }
}