import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * This class represents the data of out guessing game and is both
 * a singleton and an observable. Stores all incoming and outgoing
 * chat data. Notifies its observers when either of these change.
 * @author Jacob Balikov
 * @version GuessingGame v1.0
 */
public class Repository extends Observable {
    public static final int NO_DATA = 0;
    public static final int OUTGOING_DATA = 1;
    public static final int INCOMING_DATA = 2;
    private List<String> incomingData;
    private List<String> outgoingData;
    private static Repository repo;

    /**
     * Private constructor for the repository since
     * it is a singleton.
     */
    private Repository(){
        incomingData = new ArrayList<>();
        outgoingData = new ArrayList<>();
    }

    /**
     * A way for other classes to access the repo.
     * @return The single shared repo
     */
    public static Repository getRepo(){
        if(repo == null)
            repo = new Repository();
        return repo;
    }

    /**
     * Adds a string to the repo's list of outgoing
     * data. Notifies observers with flag.
     * @param s The string to be added
     */
    public void addOutgoing(String s){
        outgoingData.add(s);
        setChanged();
        notifyObservers(OUTGOING_DATA);
    }

    /**
     * Adds a string to the repo's list of incoming
     * data. Notifies observers with flag.
     * @param s The string to be added
     */
    public void addIncoming(String s){
        incomingData.add(s);
        setChanged();
        notifyObservers(INCOMING_DATA);
    }

    /**
     * Getter for the repo's list of outgoing data.
     * @return The repo's list of outgoing data
     */
    public List<String> getOutgoing(){
        return outgoingData;
    }

    public String getRecentOutgoing() {
        if (!outgoingData.isEmpty()) {
            return outgoingData.get(outgoingData.size() - 1);
        } else {
            return null;
        }
    }
    /**
     * Getter for the repo's list of incoming data.
     * @return The repo's list of incoming data
     */
    public List<String> getIncoming(){
        return incomingData;
    }
    public String getRecentIncoming() {
        if (!incomingData.isEmpty()) {
            return incomingData.get(incomingData.size() - 1);
        } else {
            return null;
        }
    }
    /**
     * Clears the repo's list of outgoing data.
     * Notifies observers with flag.
     */
    public void clearOutgoing(){
        outgoingData.clear();
        setChanged();
        notifyObservers(OUTGOING_DATA);
    }

    /**
     * Clears the repo's list of incoming data.
     * Notifies observers with flag.
     */
    public void clearIncoming(){
        incomingData.clear();
        setChanged();
        notifyObservers(INCOMING_DATA);
    }
}
