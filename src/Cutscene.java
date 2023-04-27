import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Cutscene. Stores lines of text to process visually
 * @author Tyler Gu
 * @version 1.3
 * @since 1.0
 */
public class Cutscene {
    private String[] lines;
    private int lineNumber = 0;

    // Makes a cutscene out of the lines
    public Cutscene (String[] line) {
        lines = line;
    }

    /** Advances the cutscene*/
    public void advanceCutscene () {
        lineNumber ++;
        if (lineNumber == lines.length) { // If it's the amount of lines, then end
            Game.endCutscene();
            lineNumber = 0;
        }
    }

    /** Draws it out in helvetica*/
    public void draw(GraphicsContext pen) {
        pen.setFill(Color.CORNFLOWERBLUE);
        pen.setTextAlign(TextAlignment.CENTER);
        pen.setFont(Font.font("Helvetica", 30));
        pen.fillText(lines[lineNumber], 300, 300);
        pen.setFont(Font.font("Helvetica", 14));
        pen.fillText("click to continue", 300, 325);
    }
}
