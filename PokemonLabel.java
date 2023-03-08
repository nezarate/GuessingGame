import javax.swing.*;
import java.awt.*;

/**
 * PokemonLabel class that encapsulates each Pokemon icon
 * @author Jin Wu
 */
public class PokemonLabel extends JLabel{
    String name;
    Boolean grey;

    public static String resourcePath = "resources/";

    // Constructor
    public PokemonLabel(String name){
        super();
        this.name = name;
        grey = false;
    }

    public String getName(){
        return this.name;
    }

    // Changes the Label image to the image pointed to via filename
    public void setImage(String filename){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image image = t.getImage(filename);
        // resizes image to fit a 900 x 400 display
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // sets resized image as the Icon
        Icon icon = new ImageIcon(image);
        this.setIcon(icon);
    }

    // Switches from normal image to greyed out
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
