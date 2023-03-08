import javax.swing.*;
import java.awt.*;
/**
 * This class represents the whole of our guessing game. Creates the layout
 * for our guessing game, sets up observers, and starts threads. Determines
 * whether you will be the host (server socket) or not (regular socket)
 * @author Giovanni Librizzi, Nicholas Zarate, Jin Wu, Jacob Balikov, Umair Pathan, Amogh Prajapat
 * @version GuessingGame v1.0
 */
public class Main extends JFrame{

    private ChatPanel chatpanel;
    private Board board;

    /**
     * Public constructor that instantiates globals
     * and does some other setup.
     */
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

    /**
     * Main method, what we run to start our guessing game. Deals
     * with choosing a host along with setting up the window,
     * observers, and threads.
     * @param args Command line arguments
     */
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
