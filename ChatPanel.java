import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel implements Observer {

    public ChatPanel() {
        GridLayout grid = new GridLayout(3, 1);
        this.setLayout(grid);


        JTextArea textSend = new JTextArea("You can type here to send messages to another user (disappear once sent?)");

        JTextArea textReceive = new JTextArea("Messages received will be shown here\nmessage 2\nmessage 3\nmessage4\nmessage5\nmessage6");
        textReceive.setEditable(false);
        JScrollPane scrollPaneReceive = new JScrollPane(textReceive);
        scrollPaneReceive.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton buttonSend = new JButton("Send");

        this.add(scrollPaneReceive);
        this.add(textSend);
        this.add(buttonSend);


    }


    public static void main(String[] args){
        ChatPanel chatPanel = new ChatPanel();
        JFrame f = new JFrame();
        f.add(chatPanel);
        f.setSize(900, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
