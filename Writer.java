
import java.awt.image.ReplicateScaleFilter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * Writes data when an observer detects new outgoing data using a thread that's looping
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version GuessingGame v1.0
 */
public class Writer implements Runnable, Observer {

    boolean flag = false;
    boolean run = true;
    boolean host;

    public Writer(boolean host) {
        this.host = host;
    }

    /**
     * This method overrides the run() method of Runnable to allow multithreading of the Writer class. In the method
     * sockets and data streams are created to allow communication of data between the players of the guessing
     * game.
     */
    @Override
    public void run(){

        ServerSocket server_socket;
        Socket socket;
        DataInputStream input;
        DataOutputStream output;

        try {
            if (host) {
                server_socket = new ServerSocket(6666);
                System.out.println("Waiting for player to connect");
                socket = server_socket.accept();
            } else {
                socket = new Socket("localhost" , 6667);
            }
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            while(run) {
                input = new DataInputStream(socket.getInputStream());

                if (flag) {
                    output = new DataOutputStream(socket.getOutputStream());
                    if (Repository.getRepo().getRecentOutgoing() != null) {
                        String last = Repository.getRepo().getRecentOutgoing(); //.get(Repository.getRepo().getOutgoing().size() - 1 ));
                        output.writeUTF(last);
                    }
                    flag = false;
                }

            }
            socket.close();
            input.close();
            output.close();
        } catch (IOException  ex){
            System.out.println(ex);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        int data = (int)arg;
        if (data == Repository.OUTGOING_DATA) {
            flag = true;
        }
        System.out.println("Writer !! " + flag);
    }
}
