
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class Writer implements Runnable, Observer {

    boolean flag = false;
    @Override
    public void run(){

        ServerSocket server_socket;
        Socket server;
        DataInputStream input;
        DataOutputStream output;
        try {
            server_socket = new ServerSocket(6666);
            System.out.println("Waiting for player to connect");
            server = server_socket.accept();
            input = new DataInputStream(server.getInputStream());
            output = new DataOutputStream(server.getOutputStream());

            while(flag){
                String last = (Repository.getRepo().getIncoming().get(Repository.getRepo().getIncoming().size() - 1 ));
                output.writeUTF(last);
                Thread.sleep(10000);
                String msg = input.readUTF();
                System.out.println(msg);

            }
            server.close();
            input.close();
            output.close();
        } catch (IOException | InterruptedException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        flag = true;
    }
}
