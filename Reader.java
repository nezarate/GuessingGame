/**
 * worker
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Reader implements Runnable{
    Socket socket = null;
    DataInputStream input = null;

    DataOutputStream output = null;

    public Reader(int port){
        try {

            socket = new Socket("localhost" , port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            while(true){

                String last = (Repository.getRepo().getOutgoing().get(Repository.getRepo().getOutgoing().size() - 1 ));

                System.out.println(last);

                if (last.equalsIgnoreCase("correct")){
                    break;
                }

            }

            socket.close();
            input.close();
            output.close();
        } catch (IOException ex){
            System.out.println(ex);
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (input != null)
                    input.close();
                if (output != null)
                    output.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void run(){
        while(true){
            Repository.getRepo().getOutgoing();
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }

}