
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Writer {
    ServerSocket ss;
    Socket s;
    DataInputStream dis;

    public Writer(int port){
        try {
            ss = new ServerSocket(port);
            s = ss.accept();
            dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            ss.close();
        } catch (IOException ex){System.out.println(ex);}

    }

}
