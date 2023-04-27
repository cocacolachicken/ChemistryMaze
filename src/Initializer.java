import java.io.IOException;

/** Class to store the method of booting up the game and setting values right
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */

public class Initializer {
    /** This "initializes" in the sense that it sets all the variables and list and list data to the values coded in
     * @throws IOException*/
    public static void initialize () throws IOException {
        ItemDirectory.initialize();
        Crafter.initialize();
        ObstacleDirectory.initialize();
        MazeBoard.initialize();
        // Starting cutscene, basically like loading in dialogue
        Game.cueCutscene(new Cutscene(new String[]{"There's something at the end of the maze...", "Allegedly, it's a rare vending machine.", "Use WASD to move."}));
    }
}
