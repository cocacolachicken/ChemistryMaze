import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

/*Unfortunately I started commenting TOO late to be able to stay sane and have proper JavaDoc commenting. If I show up tired that's why.*/
/** Where the game is launched and drawn and where controls are first handled
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */
public class GameLauncher extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
    }

    /**
     * draw
     * Draws the scene
     */
    public void draw(GraphicsContext pen) {
        // Draw + clear rect to get rid of previous frames
        pen.clearRect(0, 0, window.getHeight(), window.getWidth());
        Game.draw(pen, matrix, mouse.x, mouse.y);
    }

    // Sends these values into the Game class
    /**
     * mouseCLicked
     * Passes on the values of mouseClicked to Game
     */
    public void mouseClicked() {
        Game.clicked(mouse.x, mouse.y);
    }

    /**
     * keyPressed
     * Passes on the values of mouseClicked to KeyPressed
     */
    public void keyPressed () {
        Game.key(key);
    }
}
