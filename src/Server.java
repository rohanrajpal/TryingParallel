import java.io.*;
import java.net.*;
public class Server {
    public static void main(String args[ ])
            throws IOException {
/* create a server socket
bound to the specified port 1234 */
        ServerSocket me = new ServerSocket(1234);
/* Server is now listening
for incoming client’s request */
        while (true) {
            /* Connection is established */
            Socket connection = me.accept();
            System.out.println("Connected");
/* Spawn a thread for every
connecting client */
            new Thread(new
                    ConnectionHandler(connection)).start();
        }
    }
}
class ConnectionHandler implements Runnable{
    Socket connection;
    ConnectionHandler(Socket connection) {
        this.connection = connection;
    }
    public void run() {
        DataOutputStream out = null;
        try {
            out = new
                    DataOutputStream(connection.getOutputStream());
            out.writeUTF("Hello Client Rohan!!");
        } catch (IOException e) {
            /*Do something*/
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}