import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

/** For general "meta" stuff, like passing inputs or tracking what scene and visuals the player should see
 * @author Tyler Gu
 * @version 1.3
 * @since 1.0
 */
public class Game {
    /** CurrentMenu values: 0 = actual maze with controls, 1 = dialogue, 2 = start menu, 3 = end menu*/
    private static int currentMenu = 2;
    /** Cutscene is current cutscene*/
    private static Cutscene cutscene;
    /** This is to keep track of which obstacle is being interacted with*/
    private static Obstacle activeObstacle;

    /** Passes input to InputHandler static class*/
    public static void clicked (double x, double y) {
        InputHandler.handleInput(x, y, currentMenu);
    }
    /** Passes input to InputHandler static class*/
    public static void key (Keyboard keyCode) {
        InputHandler.handleInput(keyCode, currentMenu);
    }

    /** Draws, passes values to SceneHandler*/
    public static void draw (GraphicsContext pen, Matrix matrix, double mouseX, double mouseY) {
        SceneHandler.drawScene(pen, currentMenu, matrix, mouseX, mouseY);
    }

    /** Cues a cutscene (c), makes it active*/
    public static void cueCutscene (Cutscene c) {
        cutscene = c;
        currentMenu = 1;
    }

    /** Methods to handle cutscenes*/
    public static Cutscene getCurrentCutscene () {
        return cutscene;
    }

    /** Gets current cutscene*/
    public static void endCutscene () { // Sets back to "normal" gameplay
        currentMenu = 0;
        cutscene = null;
        // Active obstacle becomes inactive and null when the cutscene ends
        if (activeObstacle != null) {
            activeObstacle.setActive(false);
            activeObstacle = null;
        }
    }

    /** Adds active obstacle*/
    public static void addActiveObstacle (Obstacle a) {
        activeObstacle = a;
    }

    /** Starts the game*/
    public static void startGame () throws IOException {
        currentMenu = 0;
        Initializer.initialize();
    }

    /** Ends the game, transitions it to scene 3*/
    public static void endGame () {
        currentMenu = 3;
    }
}
