
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Writer {
    ServerSocket server_socket = null;
    Socket server = null;
    DataInputStream input = null;

    DataOutputStream output = null;

    public Writer(int port){
        try {
            server_socket = new ServerSocket(port);
            server = server_socket.accept();
            input = new DataInputStream(server.getInputStream());
            output = new DataOutputStream(server.getOutputStream());

            while(true){

                String last = (Repository.getRepo().getIncoming().get(Repository.getRepo().getIncoming().size() - 1 ));

                System.out.println(last);

                if (last.equalsIgnoreCase("correct")){
                    break;
                }

            }

            server.close();
            input.close();
            output.close();
        } catch (IOException ex){
            System.out.println(ex);
        }

    }

}
