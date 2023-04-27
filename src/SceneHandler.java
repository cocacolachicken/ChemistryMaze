import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.io.FileInputStream;

/** This class handles everything related to the visual aspect of the scene
 * @author Tyler Gu
 * @version 1.3
 * @since 1.0
 */
public class SceneHandler {
    // Constant + things to manage the bobbing up and down angles
    private static final int size = 50;
    private static double ang = 0;
    private static int itemSelected = -1;

    /** draws according to currentMenu
     * @param pen GraphicsContext to draw in
     * @param currentMenu CurrentMenu to draw
     * @param matrix Matrix to do transformations to
     * @param mouseX X coordinate of mouse
     * @param mouseY Y coordinate or mouse
     */
    public static void drawScene (GraphicsContext pen, int currentMenu, Matrix matrix, double mouseX, double mouseY) {
        if (currentMenu == 0 || currentMenu == 1) { // Cutscene / "normal" gameplay menu

            if (mouseY > 500 && mouseY < 590) { // Selects item, highlights it in yellow
                if (mouseX > 100 && mouseX < 180) {
                    itemSelected = 0;
                } else if (mouseX > 180 && mouseX < 260) {
                    itemSelected = 1;
                } else if (mouseX > 260 && mouseX < 340) {
                    itemSelected = 2;
                } else if (mouseX > 340 && mouseX < 420) {
                    itemSelected = 3;
                } else if (mouseX > 420 && mouseX < 500) {
                    itemSelected = 4;
                }
            } else itemSelected = -1;

            MazeBoard.get(Player.getBoard().getX(), Player.getBoard().getY()).draw(size, pen, matrix);
            Player.drawPlayer(size, pen);
            Player.drawInventory(pen, itemSelected);
            if (currentMenu == 1) { // This is only called if there's a cutscene active
                Game.getCurrentCutscene().draw(pen);
            }
        } else if (currentMenu == 2) { // Start up menu
            // Bottom message that oscillates angle wise
            matrix.push();
                matrix.translate(300, 450);
                matrix.rotate(Math.sin(Math.toRadians(ang)) * 15); // Instead of something jagged
                pen.setTextAlign(TextAlignment.CENTER);
                pen.setFont(Font.font("comic sans ms", 36));
                pen.fillText("by tyler / click to start", 0, 0);
            matrix.pop();

            // Title text
            try {
                pen.setFont(Font.loadFont(new FileInputStream("Resources/blox-brk/Blox2.ttf"), 72 * (1 + 0.1*Math.sin(Math.toRadians(ang*2 - 30))))); // Loads in a font through "file input stream."
                // Size is controlled through the sine function to make it oscillate, but at 2x the speed.
            } catch (Exception e) {
                pen.setFont(Font.font("comic sans ms", 36));
            }
            incrementAngle(); // This changes the value so it fluctuates
            pen.setTextAlign(TextAlignment.CENTER);
            pen.fillText("Chemistry\nMaze", 300, 200);
        } else if (currentMenu == 3) { // End screen
            // Background image
            Image n = null;
            try {
                n = new Image(new FileInputStream("Resources/images/soda.jpg"));
            } catch (Exception ignored) {

            }
            pen.drawImage(n, 0, 0, 600, 600);
            pen.setFill(Color.grayRgb(255, 0.75)); // Making it a bit whited out
            pen.fillRect(0, 0, 600, 600);

            matrix.push(); // Same thing, just a rotating thing in the title
                matrix.translate(300, 150);
                pen.setTextAlign(TextAlignment.CENTER);
                matrix.rotate(Math.sin(Math.toRadians(ang)) * 15);
                try {
                    pen.setFont(Font.loadFont(new FileInputStream("Resources/blox-brk/Blox2.ttf"), 72)); // Loads in a font through "file input stream."
                } catch (Exception e) {
                    pen.setFont(Font.font("comic sans ms", 36));
                }
                pen.setFill(Color.BLACK);
                pen.setTextAlign(TextAlignment.CENTER);
                pen.fillText("Chemistry\nMaze", 0, 0);
            matrix.pop();

            // Ending message
            pen.setFill(Color.BLACK);
            pen.setTextAlign(TextAlignment.CENTER);
            pen.setFont(Font.font("comic sans ms", 36));
            pen.fillText("you beat the game!\nyou found a rare soda!\ncongratulations!", 300, 400);
            incrementAngle();
        }
    }

    /** Increments angle and resets it to 0 if at 360
     * */
    public static void incrementAngle () {
        ang += 3;
        if (ang == 360) {
            ang = 0;
        }
    }
}
