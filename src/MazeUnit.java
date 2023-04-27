import javafx.scene.canvas.GraphicsContext;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/** A vehicle for a 2d array of cells
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */
public class MazeUnit {
    private int size; // Size of the unit in cells
    private ArrayList<ArrayList<Cell>> cells; // Array of the cells. This class basically just acts as a vehicle for this

    // Initializes a blank maze with "default" cells
    public MazeUnit (int big) throws FileNotFoundException {
        size = big;
        this.cells = new ArrayList<>(size);
        // Initializes to blank
        for (int x = 0; x != size; x ++) {
            this.cells.add(new ArrayList<>());
            for (int y = 0; y != size; y++)
                this.cells.get(x).add(new Cell());
        }
    }

    /**
     * Gets a unit from this using x and y
     * @param x position x
     * @param y position y
     * @return the one requested
     * */
    public Cell getCell (int x, int y) {
        if (y > 6) {
            return cells.get(x).get(6);
        } else if (y < 0) {
            return cells.get(x).get(0);
        } else if (x < 0) {
            return cells.get(0).get(y);
        } else if (x > 6) {
            return cells.get(6).get(y);
        }
        return cells.get(x).get(y);
    }
    /**
     * Gets a unit from this using Position
     * @param p position
     * @return the one requested
     * */
    public Cell getCell (Position p) {
        if (p.getY() > 6) {
            return cells.get(p.getX()).get(6);
        } else if (p.getY() < 0) {
            return cells.get(p.getX()).get(0);
        } else if (p.getX() < 0) {
            return cells.get(0).get(p.getY());
        } else if (p.getX() > 6) {
            return cells.get(6).get(p.getY());
        }
        return cells.get(p.getX()).get(p.getY());
    }

    /** Draws the maze unit
     * @param scale how big
     * @param pen GraphicsContext to draw
     * @param matrix the matrix to translated
     * */
    public void draw(int scale, GraphicsContext pen, Matrix matrix) {
        for (int x = 0; x != this.size; x++) {
            for (int y = 0; y != this.size; y++) {
                matrix.push();
                    matrix.translate(x*scale + 125, y*scale + 75);
                    cells.get(x).get(y).drawCell(pen, scale, new Position(x, y));
                matrix.pop();
            }
        }
    }
}
