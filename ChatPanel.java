import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Creates a chat panel that can be used to communicate with another user
 *
 * @author Giovanni Librizzi
 */
public class ChatPanel extends JPanel implements Observer {
    private List<String> chatReceive;
    private JTextArea textReceive, textSend;

    /**
     * Set up the panel that contains 2 JTextAreas, one for sending and one for receiving chat messages, and a Run JButton
     */
    public ChatPanel() {
        GridLayout grid = new GridLayout(3, 1);
        this.setLayout(grid);


        textSend = new JTextArea("You can type here to send messages to another user (disappear once sent?)");

        textReceive = new JTextArea("Messages received will be shown here\nmessage 2\nmessage 3\nmessage4\nmessage5\nmessage6");
        textReceive.setEditable(false);
        JScrollPane scrollPaneReceive = new JScrollPane(textReceive);
        scrollPaneReceive.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton buttonSend = new JButton("Send");

        this.add(scrollPaneReceive);
        this.add(textSend);
        this.add(buttonSend);


    }

    private void updateText(List<String> strings, JTextArea textArea) {
        textArea.removeAll();
        for (String s : strings) {
            textArea.append(s + "\n");
            textArea.update(textArea.getGraphics());
        }
    }

    /**
     * Updates chat box via Repository observable
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        int data = (int)arg;
        switch (data) {
            case Repository.OUTGOING_DATA:

                break;

            case Repository.INCOMING_DATA:
                chatReceive = Repository.getRepo().getIncoming();
                updateText(chatReceive, textReceive);
                break;
        }
    }
}
