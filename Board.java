import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Board class to display the grid of guessable images inside a JLabel
 *
 */
public class Board extends JPanel implements MouseListener {

    public static String resourcePath = "resources/";
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

    public Board() {
        // Setting 3x8 grid layout for images
        GridLayout grid = new GridLayout(3, 8);
        this.setLayout(grid);
        // Displaying images onto the grid layout
        for (int i = 0; i < 24; i++) {
            PokemonLabel label = new PokemonLabel(pokemonImages.get(i));
            label.setImage(resourcePath + pokemonImages.get(i));
            label.addMouseListener(this);
            this.add(label);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ((PokemonLabel) e.getSource()).switchImageState();
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
