import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Board extends JPanel {
    public static List<String> pokemonImages = List.of(
            "Squirtle.png", "Wartortle.png", "Blastoise.png",
            "Abra.png", "Kadabra.png", "Alakazam.png",
            "Growlithe.png", "Arcanine.png",

            "Bulbasaur.png", "Ivysaur.png", "Venusaur.png",
            "Caterpie.png", "Metapod.png", "Butterfree.png",
            "Pikachu.png", "Raichu.png",
            "Charmander.png", "Charmeleon.png", "Charizard.png",
            "Pidgey.png", "Pidgeot.png", "Pidgeotto.png",
            "Slowpoke.png", "Slowbro.png"
    );
    public Board(){
        // Setting 3x8 grid layout for images
        GridLayout grid = new GridLayout(3, 8);
        this.setLayout(grid);
        // Displaying images onto the grid layout
        for(int i = 0; i < 24; i++){
            Toolkit t = Toolkit.getDefaultToolkit();
            Image image = t.getImage(pokemonImages.get(i));
            // resizes image to fit a 900 x 400 display
            image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            Icon icon = new ImageIcon(image);
            JLabel label = new JLabel();
            label.setIcon(icon);
            this.add(label);
        }
    }

    public static void main(String[] args){
        Board board = new Board();
        JFrame f = new JFrame();
        f.add(board);
        f.setSize(900, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
