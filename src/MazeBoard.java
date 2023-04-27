import java.io.IOException;
import java.util.ArrayList;

/** A vehicle for the ArrayList<ArrayList<Maze>> variable
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */
public class MazeBoard {
    // Actual maze data
    private static ArrayList<ArrayList<MazeUnit>> maze;
    // Values for how big / tall the units will be stacked
    private static final int big = 5;
    private static final int tall = 3;
    // Side length of the maze units
    private static final int unitSize = 7;

    /** Initializes the tester board.
     * Original test scenario was that a man gets poisoned but that was too graphic (only thing I could think of).
     * No items remain from then so nothing makes sense if you try to load it
     */
    public static void testInitialize () throws IOException {
        maze = new ArrayList<>();
        for (int x = 0; x != big; x++) {
            maze.add(new ArrayList<>());
            for (int y = 0; y != tall; y++)
                maze.get(x).add(new MazeUnit(unitSize));
        }
        for (int x = 0; x != big; x++) {
            for (int y = 0; y != tall; y++) {
                if (y != 0) { // Teleport up
                    maze.get(x).get(y).getCell((unitSize-1)/2, 0).acceptTeleport(new Position(x, y-1), 'u');
                }
                if (x != big-1) { // Teleport right
                    maze.get(x).get(y).getCell(unitSize-1, (unitSize-1)/2).acceptTeleport(new Position(x+1, y), 'r');
                }
                if (y != tall-1) { // Teleport down
                    maze.get(x).get(y).getCell((unitSize-1)/2, unitSize-1).acceptTeleport(new Position(x, y+1), 'd');
                }
                if (x != 0) { // Teleport left
                    maze.get(x).get(y).getCell(0, (unitSize-1)/2).acceptTeleport(new Position(x-1, y), 'l');
                }
            }

        }
        String[] cutsceneLOL = {"I will never", "become an engineer" ,
                "LLOL"};
        maze.get(1).get(0).getCell(0, (unitSize-1)/2).acceptObstacle(ObstacleDirectory.getObstacle(0), new Position
                (1,0), new Position(0, (unitSize-1)/2), 'r');
        maze.get(0).get(0).getCell(3, 3).acceptItem(ItemDirectory.getItem(0));
        maze.get(0).get(1).getCell(3, 3).acceptItem(ItemDirectory.getItem(1));
        maze.get(1).get(0).getCell(3, 3).acceptItem(ItemDirectory.getItem(2));
        maze.get(0).get(0).getCell(2, 2).acceptCutscene(new Cutscene(cutsceneLOL));
    }

    /**
     * Initializes a blank set of units and then uses the LevelData to initialize those
     * @throws IOException
     */
    public static void initialize () throws IOException {
        maze = new ArrayList<>();
        for (int x = 0; x != big; x++) {
            maze.add(new ArrayList<>());
            for (int y = 0; y != tall; y++)
                maze.get(x).add(new MazeUnit(unitSize));
        }
        LevelData.initializeBoard();
    }

    /**
     * Gets a MazeUnit from maze using two integers
     * @param x position x
     * @param y position y
     * @return the one requested
     * */
    public static MazeUnit get (int x, int y) {
        return maze.get(x).get(y);
    }

    /**
     * Gets a MazeUnit from maze using Position
     * @param p position
     * @return the one requested
     * */
    public static MazeUnit get (Position p) {return maze.get(p.getX()).get(p.getY());}

    public static int getUnitSize () {
        return unitSize;
    }
}
