import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/** To keep track of obstacles
 * @author Tyler Gu
 * @version 1.3 Changed src/images/... to Resources/images/...
 * @since 1.0
 */
public class ObstacleDirectory {
    // class is just a vehicle for this list
    private static ArrayList<Obstacle> obstacles = new ArrayList<>();

    /** Adds an obstacle
     * @param n name of obstacle
     * @param destroy item to destroy obstacle
     * @param image image that the obstacle is represented by
     * @param c cutscene that plays upon destruction
     */
    private static void addObstacle (String n, Item destroy, String image, Cutscene c) throws FileNotFoundException {
        obstacles.add(new Obstacle(n, destroy, new Image(new FileInputStream(image)), c, obstacles.size()));
    }

    /**
     * Initializes the obstacles in this
     */
    public static void initialize () throws FileNotFoundException {
        addObstacle("Guard", ItemDirectory.getItem(5), "Resources/images/guard.jpeg", new Cutscene(
                new String[] {"Do I really want this coke?", "Hm... *sip*", "It's good", "I'll let you through"}));
        addObstacle("Tree", ItemDirectory.getItem(8), "Resources/images/tree.jpeg", new Cutscene(
                new String[]{"You use the lighter.", "The butane combusts with oxygen....", "...which creates fire. *sss*,",
                        "The tree burns to ash."}
        ));
        addObstacle("Guard2", ItemDirectory.getItem(11), "Resources/images/guard.jpeg", new Cutscene(
                new String[]{"Oh! That's perfect.", "I'll let you through now, I'm satisfied."}
        ));
        addObstacle("Acid", ItemDirectory.getItem(12), "Resources/images/acid.jpeg", new Cutscene(
                new String[]{"You pour the sodium hydroxide.", "The mixture bubbles.", "It's safe to cross now."}
        ));
        addObstacle("Guard3", ItemDirectory.getItem(16), "Resources/images/guard.jpeg", new Cutscene(
                new String[]{"Oh! That's a mineral SPF50.", "Make sure to reapply after 2 hours!"}
        ));
        addObstacle("Glass door", ItemDirectory.getItem(19), "Resources/images/plexiglass.jpeg", new Cutscene(
                new String[]{"The plexiglass gets blown up...", "...from the explosion of the sodium and water."}
        ));
    }

    // Gets the obstacle
    public static Obstacle getObstacle (int id) {
        return obstacles.get(id);
    }
}
