import javax.swing.*;
import java.awt.*;

/**
 * PokemonLabel class that encapsulates each Pokemon icon
 * @author Jacob Balikov, Giovanni Librizzi, Nicholas Zarate, Jin Wu, Umair Pathan, Amogh Prajapat
 */
public class PokemonLabel extends JLabel{
    String name;
    Boolean grey;

    public static String resourcePath = "resources/";

    /**
     * constructor for pokemon label object
     * @param name The name of the label
     */
    public PokemonLabel(String name){
        super();
        this.name = name;
        grey = false;
    }

    /**
     * getter for the name of the PokemonLabel
     * @return The name of the PokemonLabel
     */
    public String getName(){
        return this.name;
    }

    /**
     * Changes the Label image to the image pointed to via filename
     * @param filename What image file to set the label to
     */
    public void setImage(String filename){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(filename);
        // resizes image to fit a 900 x 400 display
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // sets resized image as the Icon
        Icon icon = new ImageIcon(image);
        this.setIcon(icon);
    }

    /**
     * Greys out an image or returns it to normal if already grey
     */
    public void switchImageState(){
        if(!this.grey){
            this.setImage(resourcePath + "grey" + this.name);
            this.grey = true;
        }
        else{
            this.setImage(resourcePath + this.name);
            this.grey = false;
        }
    }

}
