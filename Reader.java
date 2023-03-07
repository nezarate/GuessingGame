/**
 * worker
 */
import java.io.DataOutputStream;
import java.net.Socket;

public class Reader implements Runnable {
    private Socket s;
    private DataOutputStream d;
    public Reader(String address, int port){
        try {
            s = new Socket(address, port);
            d = new DataOutputStream(s.getOutputStream());
            d.writeUTF("Hello Server");
            d.flush();
            d.close();
            s.close();
        } catch (Exception e){System.out.println(e);}
    }

    @Override
    public void run(){
        while(true){
            Repository.getRepo().getIncoming();
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }

}