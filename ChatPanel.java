import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Creates a chat panel that can be used to communicate with another user
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version GuessingGame v1.0
 */
public class ChatPanel extends JPanel implements Observer {
    private JTextArea textReceive, textSend;
    private ActionListener actionListener = new ControlHandler(this);


    /**
     * Set up the panel that contains 2 JTextAreas, one for sending and one for receiving chat messages, and a Run JButton
     */
    public ChatPanel() {
        GridLayout grid = new GridLayout(3, 1);
        this.setLayout(grid);


        textSend = new JTextArea("Type here to send messages to another user!");

        textReceive = new JTextArea("Chat log will be shown here.");
        textReceive.setEditable(false);
        JScrollPane scrollPaneReceive = new JScrollPane(textReceive);
        scrollPaneReceive.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton buttonSend = new JButton("Send");

        buttonSend.addActionListener(actionListener);

        this.add(scrollPaneReceive);
        this.add(textSend);
        this.add(buttonSend);

    }


    private void updateText(List<String> strings, JTextArea textArea) {
        textArea.setText("");
        for (String s : strings) {
            textArea.append(s + "\n");
            textArea.update(textArea.getGraphics());
        }
    }

    /**
     * Updates chat with the current received text
     */
    public void updateChat() {
        updateText(Repository.getRepo().getChatLog(), textReceive);
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
                System.out.println("ChatPanel receiving incoming data...");
                updateChat();
                break;
        }
    }


    /**
     * Gets a string that is the user's message they're sending
     * @return The string that's in the sending textbox
     */
    public String getSendText() {
        return textSend.getText();
    }

    /**
     * Resets the sending text jtextbox to be empty.
     */
    public void resetTextSend() {
        textSend.setText("");
    }
}
