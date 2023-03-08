import javax.swing.*;
import java.awt.*;
public class Main extends JFrame{
    private ChatPanel chatpanel;
    private Board board;
    public Main(){
        super("Who's that Pokemon????");
        chatpanel = new ChatPanel();
        board = new Board();

        // layout
        setLayout(new GridLayout(2,0));
        add(board);
        add(chatpanel);

    }

    public static void main(String[] args){

        int response = JOptionPane.showConfirmDialog (null, "Are you the first player to run the game? If not please select no.","WARNING", JOptionPane.YES_NO_OPTION);


        if(response == JOptionPane.YES_OPTION) {
            Main main = new Main();
            main.setSize(900, 900);
            main.setVisible(true);
            main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(null, "You are Player 1. Enjoy the game!");
            Writer writer = new Writer();
            Thread writerThread = new Thread(writer);
            writerThread.start();

        } else{

            Main main = new Main();
            main.setSize(900, 900);
            main.setVisible(true);
            main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(null, "You are Player 1. Enjoy the game!");
            Reader reader = new Reader();
            Thread readerThread = new Thread(reader);
            readerThread.start();
        }


    }


}
