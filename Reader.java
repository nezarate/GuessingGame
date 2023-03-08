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


// needs to observe
//

public class Reader implements Runnable, Observer {
    boolean flag = false;
    @Override
    public void run(){

        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;


        try {

            socket = new Socket("localhost" , 6666);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            while(flag){

                System.out.println(input.readUTF());
                Thread.sleep(10000);
                String last = (Repository.getRepo().getOutgoing().get(Repository.getRepo().getOutgoing().size() - 1 ));
                output.writeUTF(last);
            }

            socket.close();
            input.close();
            output.close();
        } catch (IOException ex){
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        flag = true;
    }
}