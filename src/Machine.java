import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/** Machines are basically obstacles that a player may step on where you can use an item on it
 * And it will do a multitude of things, like give another item, maybe a cutscene, or end the game
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */
public class Machine {
    private Map<Integer, Object> recipes = new HashMap<>();
    private Image image;
    private String name;

    // Makes a machine
    public Machine (String img, String name) throws FileNotFoundException {
        this.image = new Image(new FileInputStream(img));
        this.name = name;
    }

    /** Adds a recipe. <Object> instead of <____> because it can allow for more versatility in this*/
    public void addRecipe(int ingredient, Object result) {
        recipes.put(ingredient, result);
    }

    /**
     * @param ingredient name is a relic but still fits. The key to access whatever object.
     * @return the object that the machine produces
     * */
    public Object craft (Item ingredient) {
        return recipes.get(ingredient.getID());
    }

    /** Draws the machine
     * @param pen the GraphicsContext
     * */
    public void draw (GraphicsContext pen) {
        pen.drawImage(image, 0, 0, 50, 50);
    }

    public String getName () {return name;}
}
