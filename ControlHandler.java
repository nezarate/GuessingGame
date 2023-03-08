import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Interfaces with other objects and allows actions to be handled in a separate class (Control in MCV)
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 * @version GuessingGame v1.0
 */
public class ControlHandler implements ActionListener, MouseListener {

    private ChatPanel chatPanel;

    /**
     * Initializes to be action listener with the chat panel
     * @param chatPanel
     */
    public ControlHandler(ChatPanel chatPanel) {
        this.chatPanel = chatPanel;
    }

    /**
     * Initializes to be mouse listener with the board panel
     */
    public ControlHandler() {

    }


    /**
     * Currently only sends a string to the writer worker once Send is pressed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (chatPanel != null) {
            String strSend = chatPanel.getSendText();
            if (!strSend.isBlank()) {
                System.out.println(strSend);
                System.out.println("Sending to Repository\n");
                Repository.getRepo().addOutgoing(strSend);
                chatPanel.resetTextSend();
                chatPanel.updateChat();
            }
        } else {
            System.out.println("ControlHandler not implemented correctly with ActionListener");
        }


    }

    /**
     * Currently only grays out images when clicked
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        ((PokemonLabel)e.getSource()).switchImageState();
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
