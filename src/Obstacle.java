import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/** OBSTACLE! Something that you can't cross until you use an item on it
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */
public class Obstacle {
    private String name;
    private Item destroyTrigger; // Which item destroys it
    private Cutscene destroyCutscene; // Cutscene when destroyed
    private int ID; // Never used, but good for categorizing
    private boolean active = true; // Active = true means it will show and block paths (with a red line), otherwise no
    private Image image; // How it looks like

    // Constructs an obstacle with these values
    public Obstacle (String n, Item destroy, Image img, Cutscene c, int i) {
        name = n;
        destroyTrigger = destroy;
        image = img;
        destroyCutscene = c;
        ID = i;
    }

    /** Draws the obstacle on the cell (if active)
     * @param pen GraphicsContext to be drawn in
     * */
    public void drawObstacle (GraphicsContext pen) {
        if (active)
            pen.drawImage(image, 0, 0, 50, 50);
    }

    /** destroys using item, results depend on which item is used
     * @param item The item which is used on this
     * @return if it was a success or not
     * */
    public boolean destroy (Item item) {
        if (item.equals(destroyTrigger)) {
            System.out.println("Obstacle destroyed");
            cueCutscene();
            return true;
        }
        return false;
    }

    // Sets the activeness to the specified value
    public void setActive (boolean act) {
        active = act;
    }

    // Gets the name of the obstacle
    public String getName () {
        return name;
    }

    /**cues a cutscene in Game*/
    public void cueCutscene () {
        Game.cueCutscene(this.destroyCutscene);
        Game.addActiveObstacle(this);
    }
}
