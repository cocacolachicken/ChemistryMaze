import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** Stores value relating to items
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */
public class Item {
    private String name;
    private int ID;
    private String description;
    private Image image;

    // constructs an item with the values given
    public Item (String name, int ID, String description, Image image) {
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.image = image;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String getDescription() {
        return description;
    }
    public Image getImage () {return image;}

    /** Draws the item
     * @param pen GraphicsContext to be drawn in*/
    public void drawItem (GraphicsContext pen) {
        pen.drawImage(image, 0, 0, 50, 50);
    }
}
