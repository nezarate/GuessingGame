import javax.swing.*;
import java.awt.*;
public class Main extends JFrame{

    private ChatPanel chatpanel;
    private Board board;
    public Main(){
        super("Who's that Pokemon????");
        chatpanel = new ChatPanel();
        board = new Board();

        Repository.getRepo().addObserver(chatpanel);

        // layout
        setLayout(new GridLayout(2,0));
        add(board);
        add(chatpanel);

    }

    public static void main(String[] args){
        int response = JOptionPane.showConfirmDialog (null, "Are you the first player to run the game? If not please select no.","WARNING", JOptionPane.YES_NO_OPTION);

        Main main = new Main();
        main.setSize(900, 900);
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        boolean host;


        if(response == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "You are Player 1. Enjoy the game!");
            host = true;

        } else {


            JOptionPane.showMessageDialog(null, "You are Player 2. Enjoy the game!");
            host = false;
        }
        Writer writer = new Writer(host);
        Repository.getRepo().addObserver(writer);
        Thread writerThread = new Thread(writer);
        writerThread.start();
        Reader reader = new Reader(host);
        Repository.getRepo().addObserver(reader);
        Thread readerThread = new Thread(reader);
        readerThread.start();

    }


}
