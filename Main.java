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
        // setup
        Main main = new Main();
        main.setSize(900,900);
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //threads
        Thread chatThread = new Thread();
        Thread boardThread = new Thread();
        chatThread.start();
        boardThread.start();
    }


}
