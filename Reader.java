/**
 * worker
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;


/**
 * Uses a thread and loops to read data continuously, then send it
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version GuessingGame v1.0
 */
public class Reader implements Runnable, Observer {
    boolean flag = false;
    boolean run = true;
    boolean host;
    public Reader(boolean host) {
        this.host = host;
    }

    /**
     * This method overrides the run() method of Runnable to allow multithreading of the Reader class. In the method
     * sockets and data streams are created to allow communication of data between the players of the guessing
     * game.
     */
    @Override
    public void run() {

        ServerSocket server_socket;
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        String incoming;

        try {
            if (host) {
                server_socket = new ServerSocket(6667);
                System.out.println("Waiting for player to connect");
                socket = server_socket.accept();
            } else {
                socket = new Socket("localhost" , 6666);
            }

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            while(run){
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
                incoming = input.readUTF();
                if (incoming != null) {
                    System.out.println("socket incoming: " + incoming);
                    Repository.getRepo().addIncoming(incoming);
                }

            }

            socket.close();
            input.close();
            output.close();
        } catch (IOException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        int data = (int)arg;
        if (data == Repository.INCOMING_DATA) {
            flag = true;
        }
        System.out.println("Reader !! " + flag);

    }
}