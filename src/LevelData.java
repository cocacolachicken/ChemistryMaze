import java.util.ArrayList;

/** Where all the data for level is stored
 * @author Tyler
 * @version 1.3 Changed src/images/... to Resources/images/...
 * @since 1.0
 */
public class LevelData {
    /** Shorthand for the position constructor
     * @param x x position
     * @param y y position
     * @return Position(x, y)
     * */
    public static Position p (int x, int y) {
        return new Position(x, y);
    }

    /** Change collision of a cell
     * @param pos position of cell wanted
     * @param board board position of cell wanted
     * @param dir direction to be changed
     * @param b collision value to be wanted
     * */
    public static void changeCollision (Position pos, Position board, char dir, boolean b) {
        MazeBoard.get(board).getCell(pos).changeCollision(dir, b, board, pos);
    }

    /** Shorthand for the position constructor
     * Initializes all the units, and each method below is just sectioned off by unit.
     * Handles all collision, placing of machines items obstacles cutscene, and teleport locations
     * */
    public static void initializeBoard () {
        pos1_1();
        pos1_2();
        pos1_3();
        pos1_4();
        pos1_5();
        pos2_1();
        pos2_2();
        pos2_3();
        pos2_4();
        pos2_5();
        pos3_1();
        pos3_2();
        pos3_3();
        pos3_4();
        pos3_5();
    }

    /**Template for the positions*/
    public static void template () {
        // Exits

        // Items

        // Machines

        // Cutscenes

        // "Correct" path first

        // Misleading paths

        // Obstacles
    }

    // Check the notes and planning for how I made these without going insane
    public static void pos1_1 () {
        // Exits
        MazeBoard.get(p(0, 0)).getCell(6, 3).acceptTeleport(p(1, 0), 'r');
        MazeBoard.get(p(1, 0)).getCell(0, 3).acceptTeleport(p(0, 0), 'l');
        changeCollision(p(6, 3), p(0, 0),'r', false);
        changeCollision(p(0, 3), p(1, 0),'l', false);

        // Items
        MazeBoard.get(0, 0).getCell(6, 0).acceptItem(ItemDirectory.getItem(0));

        // Machines

        // Cutscenes
        MazeBoard.get(0, 0).getCell(3, 1).acceptCutscene(new Cutscene(new String[]{"Try to pick up that test tube.", "Click on it when you get it...", "...for the descriptions."}));

        // "Correct" path first
        changeCollision(p(0, 0), p(0, 0),'r', false);
        changeCollision(p(1, 1), p(0, 0),'u', false);
        changeCollision(p(1, 1), p(0, 0),'r', false);
        changeCollision(p(3, 1), p(0, 0),'l', false);
        changeCollision(p(3, 1), p(0, 0),'d', false);
        changeCollision(p(3, 3), p(0, 0),'u', false);
        changeCollision(p(3, 3), p(0, 0),'d', false);
        changeCollision(p(3, 5), p(0, 0),'u', false);
        changeCollision(p(3, 5), p(0, 0),'r', false);
        changeCollision(p(5, 5), p(0, 0),'u', false);
        changeCollision(p(5, 5), p(0, 0),'l', false);
        changeCollision(p(5, 3), p(0, 0),'d', false);
        changeCollision(p(5, 3), p(0, 0),'u', false);
        changeCollision(p(6, 2), p(0, 0),'l', false);
        changeCollision(p(6, 2), p(0, 0),'d', false);

        // Misleading paths
        changeCollision(p(0, 0), p(0, 0),'d', false);
        changeCollision(p(0, 2), p(0, 0),'u', false);
        changeCollision(p(0, 2), p(0, 0),'d', false);
        changeCollision(p(1, 3), p(0, 0),'l', false);
        changeCollision(p(1, 3), p(0, 0),'u', false);
        changeCollision(p(1, 3), p(0, 0),'d', false);
        changeCollision(p(2, 2), p(0, 0),'l', false);
        changeCollision(p(2, 2), p(0, 0),'d', false);
        changeCollision(p(0, 4), p(0, 0),'u', false);
        changeCollision(p(0, 4), p(0, 0),'d', false);
        changeCollision(p(0, 6), p(0, 0),'r', false);
        changeCollision(p(1, 5), p(0, 0),'u', false);
        changeCollision(p(1, 5), p(0, 0),'d', false);
        changeCollision(p(2, 4), p(0, 0),'u', false);
        changeCollision(p(2, 2), p(0, 0),'d', false);
        changeCollision(p(2, 6), p(0, 0),'u', false);
        changeCollision(p(2, 6), p(0, 0),'u', false);
        changeCollision(p(3, 5), p(0, 0),'l', false);
        changeCollision(p(4, 6), p(0, 0),'u', false);
        changeCollision(p(4, 6), p(0, 0),'l', false);
        changeCollision(p(6, 6), p(0, 0),'l', false);
        changeCollision(p(6, 6), p(0, 0),'u', false);
        changeCollision(p(5, 5), p(0, 0),'d', false);
        changeCollision(p(6, 4), p(0, 0),'d', false);
        changeCollision(p(3, 1), p(0, 0),'u', false);
        changeCollision(p(3, 1), p(0, 0),'r', false);
        changeCollision(p(2, 0), p(0, 0),'r', false);
        changeCollision(p(4, 0), p(0, 0),'l', false);
        changeCollision(p(4, 0), p(0, 0),'r', false);
        changeCollision(p(4, 2), p(0, 0),'u', false);
        changeCollision(p(4, 2), p(0, 0),'d', false);
        changeCollision(p(4, 4), p(0, 0),'u', false);
        changeCollision(p(5, 1), p(0, 0),'u', false);
        changeCollision(p(5, 1), p(0, 0),'r', false);
        changeCollision(p(6, 0), p(0, 0),'d', false);

        // Machines
    }
    public static void pos1_2 () {
        // Exits
        MazeBoard.get(p(1, 0)).getCell(6, 3).acceptTeleport(p(2, 0), 'r');
        MazeBoard.get(p(2, 0)).getCell(0, 3).acceptTeleport(p(1, 0), 'l');
        changeCollision(p(6, 3), p(1, 0),'r', false);
        changeCollision(p(0, 3), p(2, 0),'l', false);

        // Items
        MazeBoard.get(1, 0).getCell(4, 4).acceptItem(ItemDirectory.getItem(2));
        MazeBoard.get(1, 0).getCell(6, 4).acceptItem(ItemDirectory.getItem(1));

        // Machines
        try {
            MazeBoard.get(1, 0).getCell(3, 6).acceptMachine(new Machine("Resources/images/soda maker.png", "Soda maker"));
            MazeBoard.get(1, 0).getCell(3, 6).accessMachine().addRecipe(0, new Cutscene(new String[]{"Tube is empty", "Try filling it with CO2"}));
            MazeBoard.get(1, 0).getCell(3, 6).accessMachine().addRecipe(3, new Cutscene(new String[]{"Try putting it in the test tube"}));
            MazeBoard.get(1, 0).getCell(3, 6).accessMachine().addRecipe(4, ItemDirectory.getItem(5));
        } catch (Exception ignore) {

        }


        // Cutscenes
        MazeBoard.get(1, 0).getCell(1, 3).acceptCutscene(new Cutscene(new String[]{"There's a guard that seems exhausted.", "Give him a soda or something.", "Drop an item over the red line.", "Make sure you're facing the right way."}));
        MazeBoard.get(1, 0).getCell(3, 1).acceptCutscene(new Cutscene(new String[]{"You can drop items.", "Just press the number that is below it.", "Drop items on each other to craft."}));
        MazeBoard.get(1, 0).getCell(4, 5).acceptCutscene(new Cutscene(new String[]{"It's a soda machine!", "But it's out of CO2...", "Maybe if you dropped CO2 on it in a tube...", "...it may work."}));

        // "Correct" path first
        changeCollision(p(0, 0), p(1, 0),'r', false);
        changeCollision(p(1, 1), p(1, 0),'u', false);
        changeCollision(p(1, 1), p(1, 0),'r', false);
        changeCollision(p(3, 1), p(1, 0),'l', false);
        changeCollision(p(3, 1), p(1, 0),'d', false);
        changeCollision(p(3, 3), p(1, 0),'u', false);
        changeCollision(p(3, 3), p(1, 0),'d', false);
        changeCollision(p(3, 5), p(1, 0),'u', false);
        changeCollision(p(3, 5), p(1, 0),'r', false);
        changeCollision(p(5, 5), p(1, 0),'u', false);
        changeCollision(p(5, 5), p(1, 0),'l', false);
        changeCollision(p(5, 3), p(1, 0),'d', false);
        changeCollision(p(5, 3), p(1, 0),'u', false);
        changeCollision(p(6, 2), p(1, 0),'l', false);
        changeCollision(p(6, 2), p(1, 0),'d', false);

        // Misleading paths
        changeCollision(p(0, 0), p(1, 0),'d', false);
        changeCollision(p(0, 2), p(1, 0),'u', false);
        changeCollision(p(1, 3), p(1, 0),'l', false);
        changeCollision(p(1, 3), p(1, 0),'u', false);
        changeCollision(p(1, 3), p(1, 0),'d', false);
        changeCollision(p(2, 2), p(1, 0),'l', false);
        changeCollision(p(2, 2), p(1, 0),'d', false);
        changeCollision(p(0, 4), p(1, 0),'d', false);
        changeCollision(p(0, 6), p(1, 0),'r', false);
        changeCollision(p(1, 5), p(1, 0),'u', false);
        changeCollision(p(1, 5), p(1, 0),'d', false);
        changeCollision(p(2, 4), p(1, 0),'u', false);
        changeCollision(p(2, 4), p(1, 0),'r', false);
        changeCollision(p(2, 2), p(1, 0),'d', false);
        changeCollision(p(2, 6), p(1, 0),'u', false);
        changeCollision(p(2, 6), p(1, 0),'u', false);
        changeCollision(p(3, 5), p(1, 0),'l', false);
        changeCollision(p(4, 6), p(1, 0),'u', false);
        changeCollision(p(4, 6), p(1, 0),'l', false);
        changeCollision(p(6, 6), p(1, 0),'l', false);
        changeCollision(p(6, 6), p(1, 0),'u', false);
        changeCollision(p(5, 5), p(1, 0),'d', false);
        changeCollision(p(6, 4), p(1, 0),'d', false);
        changeCollision(p(3, 1), p(1, 0),'u', false);
        changeCollision(p(3, 1), p(1, 0),'r', false);
        changeCollision(p(2, 0), p(1, 0),'r', false);
        changeCollision(p(4, 0), p(1, 0),'l', false);
        changeCollision(p(4, 0), p(1, 0),'r', false);
        changeCollision(p(4, 2), p(1, 0),'u', false);
        changeCollision(p(4, 2), p(1, 0),'d', false);
        changeCollision(p(4, 4), p(1, 0),'u', false);
        changeCollision(p(5, 1), p(1, 0),'u', false);
        changeCollision(p(5, 1), p(1, 0),'r', false);
        changeCollision(p(6, 0), p(1, 0),'d', false);
        changeCollision(p(0, 6), p(1, 0),'u', false);

        // Obstacles
        MazeBoard.get(1, 0).getCell(6, 3).acceptObstacle(ObstacleDirectory.getObstacle(0), p(1, 0), p(6, 3), 'u');

    }
    public static void pos1_3 () {
        // Exits
        MazeBoard.get(p(2, 0)).getCell(6, 1).acceptTeleport(p(3, 0), 'r');
        MazeBoard.get(p(3, 0)).getCell(0, 1).acceptTeleport(p(2, 0), 'l');
        changeCollision(p(6, 1), p(2, 0),'r', false);
        changeCollision(p(0, 1), p(3, 0),'l', false);

        MazeBoard.get(p(2, 0)).getCell(2, 6).acceptTeleport(p(2, 1), 'd');
        MazeBoard.get(p(2, 1)).getCell(2, 0).acceptTeleport(p(2, 0), 'u');
        changeCollision(p(2, 6), p(2, 0),'d', false);
        changeCollision(p(2, 0), p(2, 1),'u', false);

        // Items
        MazeBoard.get(2, 0).getCell(6, 5).acceptItem(ItemDirectory.getItem(6));

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(1, 3), p(2, 0),'l', false);
        changeCollision(p(1, 3), p(2, 0),'r', false);
        changeCollision(p(2, 2), p(2, 0),'d', false);
        changeCollision(p(2, 2), p(2, 0),'l', false);
        changeCollision(p(1, 1), p(2, 0),'d', false);
        changeCollision(p(1, 1), p(2, 0),'r', false);
        changeCollision(p(2, 0), p(2, 0),'d', false);
        changeCollision(p(2, 0), p(2, 0),'r', false);
        changeCollision(p(4, 0), p(2, 0),'r', false);
        changeCollision(p(4, 0), p(2, 0),'l', false);
        changeCollision(p(6, 0), p(2, 0),'l', false);
        changeCollision(p(6, 0), p(2, 0),'d', false);

        // 2nd path
        changeCollision(p(3, 3), p(2, 0),'l', false);
        changeCollision(p(3, 3), p(2, 0),'r', false);
        changeCollision(p(4, 4), p(2, 0),'l', false);
        changeCollision(p(4, 4), p(2, 0),'u', false);
        changeCollision(p(2, 4), p(2, 0),'r', false);
        changeCollision(p(2, 4), p(2, 0),'l', false);
        changeCollision(p(2, 4), p(2, 0),'r', false);
        changeCollision(p(1, 5), p(2, 0),'u', false);
        changeCollision(p(1, 5), p(2, 0),'r', false);
        changeCollision(p(2, 6), p(2, 0),'u', false);

        // Misleading paths
        changeCollision(p(2, 0), p(2, 0),'l', false);
        changeCollision(p(0, 0), p(2, 0),'r', false);
        changeCollision(p(0, 0), p(2, 0),'d', false);
        changeCollision(p(0, 2), p(2, 0),'u', false);
        changeCollision(p(2, 2), p(2, 0),'r', false);
        changeCollision(p(3, 1), p(2, 0),'d', false);
        changeCollision(p(3, 1), p(2, 0),'r', false);
        changeCollision(p(5, 1), p(2, 0),'l', false);
        changeCollision(p(4, 2), p(2, 0),'l', false);
        changeCollision(p(4, 2), p(2, 0),'r', false);
        changeCollision(p(6, 2), p(2, 0),'l', false);
        changeCollision(p(6, 2), p(2, 0),'d', false);
        changeCollision(p(6, 4), p(2, 0),'u', false);
        changeCollision(p(5, 3), p(2, 0),'l', false);
        changeCollision(p(5, 3), p(2, 0),'d', false);
        changeCollision(p(5, 5), p(2, 0),'u', false);
        changeCollision(p(5, 5), p(2, 0),'d', false);
        changeCollision(p(6, 6), p(2, 0),'u', false);
        changeCollision(p(6, 6), p(2, 0),'l', false);
        changeCollision(p(4, 4), p(2, 0),'d', false);
        changeCollision(p(4, 6), p(2, 0),'u', false);
        changeCollision(p(4, 6), p(2, 0),'l', false);
        changeCollision(p(3, 5), p(2, 0),'d', false);
        changeCollision(p(0, 4), p(2, 0),'r', false);
        changeCollision(p(0, 4), p(2, 0),'d', false);
        changeCollision(p(0, 6), p(2, 0),'u', false);
        changeCollision(p(0, 6), p(2, 0),'r', false);

        // Obstacles
        MazeBoard.get(2, 0).getCell(2, 6).acceptObstacle(ObstacleDirectory.getObstacle(1), p(2, 0), p(2, 6), 'u');
    }
    public static void pos1_4 () {
        // Exits
        MazeBoard.get(p(3, 0)).getCell(6, 4).acceptTeleport(p(4, 0), 'r');
        MazeBoard.get(p(4, 0)).getCell(0, 4).acceptTeleport(p(3, 0), 'l');
        changeCollision(p(6, 4), p(3, 0),'r', false);
        changeCollision(p(0, 4), p(4, 0),'l', false);

        // Items
        MazeBoard.get(p(3, 0)).getCell(2, 4).acceptItem(ItemDirectory.getItem(18));

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(1, 1), p(3, 0),'l', false);
        changeCollision(p(1, 1), p(3, 0),'d', false);
        changeCollision(p(2, 2), p(3, 0),'l', false);
        changeCollision(p(2, 2), p(3, 0),'r', false);
        changeCollision(p(3, 3), p(3, 0),'u', false);
        changeCollision(p(3, 3), p(3, 0),'d', false);
        changeCollision(p(3, 5), p(3, 0),'u', false);
        changeCollision(p(3, 5), p(3, 0),'r', false);
        changeCollision(p(4, 4), p(3, 0),'d', false);
        changeCollision(p(4, 4), p(3, 0),'u', false);
        changeCollision(p(5, 3), p(3, 0),'d', false);
        changeCollision(p(5, 3), p(3, 0),'l', false);
        changeCollision(p(6, 4), p(3, 0),'l', false);

        // Misleading paths
        changeCollision(p(1, 1), p(3, 0),'r', false);
        changeCollision(p(3, 1), p(3, 0),'l', false);
        changeCollision(p(3, 1), p(3, 0),'u', false);
        changeCollision(p(2, 0), p(3, 0),'r', false);
        changeCollision(p(2, 0), p(3, 0),'l', false);
        changeCollision(p(0, 0), p(3, 0),'r', false);
        changeCollision(p(4, 0), p(3, 0),'l', false);
        changeCollision(p(4, 0), p(3, 0),'d', false);
        changeCollision(p(4, 2), p(3, 0),'u', false);
        changeCollision(p(0, 2), p(3, 0),'r', false);
        changeCollision(p(0, 2), p(3, 0),'d', false);
        changeCollision(p(0, 4), p(3, 0),'u', false);
        changeCollision(p(0, 4), p(3, 0),'d', false);
        changeCollision(p(0, 4), p(3, 0),'u', false);
        changeCollision(p(0, 6), p(3, 0),'u', false);
        changeCollision(p(0, 4), p(3, 0),'r', false);
        changeCollision(p(1, 3), p(3, 0),'r', false);
        changeCollision(p(1, 3), p(3, 0),'d', false);
        changeCollision(p(2, 4), p(3, 0),'u', false);
        changeCollision(p(3, 5), p(3, 0),'l', false);
        changeCollision(p(1, 5), p(3, 0),'r', false);
        changeCollision(p(1, 5), p(3, 0),'d', false);
        changeCollision(p(2, 6), p(3, 0),'r', false);
        changeCollision(p(1, 5), p(3, 0),'d', false);
        changeCollision(p(3, 5), p(3, 0),'d', false);
        changeCollision(p(4, 6), p(3, 0),'r', false);
        changeCollision(p(4, 6), p(3, 0),'r', false);
        changeCollision(p(5, 5), p(3, 0),'u', false);
        changeCollision(p(5, 5), p(3, 0),'d', false);
        changeCollision(p(5, 5), p(3, 0),'r', false);
        changeCollision(p(6, 6), p(3, 0),'u', false);
        changeCollision(p(4, 0), p(3, 0),'r', false);
        changeCollision(p(5, 1), p(3, 0),'u', false);
        changeCollision(p(5, 1), p(3, 0),'r', false);
        changeCollision(p(6, 0), p(3, 0),'d', false);
        changeCollision(p(5, 3), p(3, 0),'u', false);
        changeCollision(p(6, 2), p(3, 0),'l', false);
        changeCollision(p(6, 2), p(3, 0),'d', false);

        // Obstacles
    }
    public static void pos1_5 () {
        // Exits
        //(one way)

        // Items
        MazeBoard.get(4, 0).getCell(4, 4).acceptItem(ItemDirectory.getItem(7));

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(0, 4), p(4, 0),'r', false);
        changeCollision(p(1, 3), p(4, 0),'d', false);
        changeCollision(p(1, 3), p(4, 0),'l', false);
        changeCollision(p(0, 2), p(4, 0),'d', false);
        changeCollision(p(0, 2), p(4, 0),'r', false);
        changeCollision(p(1, 1), p(4, 0),'d', false);
        changeCollision(p(1, 1), p(4, 0),'u', false);
        changeCollision(p(2, 0), p(4, 0),'l', false);
        changeCollision(p(2, 0), p(4, 0),'r', false);
        changeCollision(p(4, 0), p(4, 0),'l', false);
        changeCollision(p(4, 0), p(4, 0),'d', false);
        changeCollision(p(4, 2), p(4, 0),'u', false);
        changeCollision(p(4, 2), p(4, 0),'d', false);
        changeCollision(p(3, 3), p(4, 0),'r', false);
        changeCollision(p(3, 3), p(4, 0),'d', false);
        changeCollision(p(4, 4), p(4, 0),'l', false);

        // Misleading paths
        changeCollision(p(1, 5), p(4, 0),'u', false);
        changeCollision(p(1, 5), p(4, 0),'l', false);
        changeCollision(p(0, 6), p(4, 0),'u', false);
        changeCollision(p(0, 6), p(4, 0),'r', false);
        changeCollision(p(2, 6), p(4, 0),'l', false);
        changeCollision(p(1, 5), p(4, 0),'r', false);
        changeCollision(p(3, 5), p(4, 0),'l', false);
        changeCollision(p(3, 5), p(4, 0),'r', false);
        changeCollision(p(3, 5), p(4, 0),'d', false);
        changeCollision(p(4, 6), p(4, 0),'l', false);
        changeCollision(p(1, 1), p(4, 0),'l', false);
        changeCollision(p(0, 0), p(4, 0),'d', false);
        changeCollision(p(2, 0), p(4, 0),'d', false);
        changeCollision(p(2, 2), p(4, 0),'u', false);
        changeCollision(p(2, 2), p(4, 0),'r', false);
        changeCollision(p(3, 1), p(4, 0),'d', false);
        changeCollision(p(4, 0), p(4, 0),'r', false);
        changeCollision(p(6, 0), p(4, 0),'l', false);
        changeCollision(p(6, 0), p(4, 0),'d', false);
        changeCollision(p(5, 1), p(4, 0),'u', false);
        changeCollision(p(5, 1), p(4, 0),'d', false);
        changeCollision(p(6, 2), p(4, 0),'l', false);
        changeCollision(p(1, 3), p(4, 0),'r', false);
        changeCollision(p(2, 4), p(4, 0),'u', false);
        changeCollision(p(5, 3), p(4, 0),'l', false);
        changeCollision(p(5, 3), p(4, 0),'r', false);
        changeCollision(p(6, 4), p(4, 0),'u', false);
        changeCollision(p(6, 4), p(4, 0),'l', false);
        changeCollision(p(6, 4), p(4, 0),'d', false);
        changeCollision(p(5, 5), p(4, 0),'d', false);
        changeCollision(p(6, 6), p(4, 0),'u', false);
        changeCollision(p(6, 6), p(4, 0),'l', false);

        // Obstacles

    }
    // Ordered by in which the player can access – this actually comes before the rightmost column middle row level
    public static void pos2_3 () {
        // Exits
        MazeBoard.get(p(2, 1)).getCell(6, 5).acceptTeleport(p(3, 1), 'r');
        MazeBoard.get(p(3, 1)).getCell(0, 5).acceptTeleport(p(2, 1), 'l');
        changeCollision(p(6, 5), p(2, 1),'r', false);
        changeCollision(p(0, 5), p(3, 1),'l', false);

        // Items
        MazeBoard.get(p(2, 1)).getCell(6, 1).acceptItem(ItemDirectory.getItem(9));

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(2, 0), p(2, 1),'d', false);
        changeCollision(p(1, 1), p(2, 1),'r', false);
        changeCollision(p(1, 1), p(2, 1),'u', false);
        changeCollision(p(0, 0), p(2, 1),'r', false);
        changeCollision(p(0, 0), p(2, 1),'d', false);
        changeCollision(p(0, 2), p(2, 1),'u', false);
        changeCollision(p(0, 2), p(2, 1),'d', false);
        changeCollision(p(0, 4), p(2, 1),'u', false);
        changeCollision(p(0, 4), p(2, 1),'r', false);
        changeCollision(p(2, 4), p(2, 1),'l', false);
        changeCollision(p(2, 4), p(2, 1),'r', false);
        changeCollision(p(3, 3), p(2, 1),'d', false);
        changeCollision(p(3, 3), p(2, 1),'u', false);
        changeCollision(p(4, 2), p(2, 1),'l', false);
        changeCollision(p(4, 2), p(2, 1),'d', false);
        changeCollision(p(4, 4), p(2, 1),'u', false);
        changeCollision(p(4, 4), p(2, 1),'d', false);
        changeCollision(p(5, 5), p(2, 1),'l', false);
        changeCollision(p(5, 5), p(2, 1),'r', false);

        // Misleading paths
        changeCollision(p(3, 1), p(2, 1),'l', false);
        changeCollision(p(3, 1), p(2, 1),'u', false);
        changeCollision(p(4, 0), p(2, 1),'l', false);
        changeCollision(p(4, 0), p(2, 1),'d', false);
        changeCollision(p(1, 3), p(2, 1),'l', false);
        changeCollision(p(1, 3), p(2, 1),'u', false);
        changeCollision(p(2, 2), p(2, 1),'l', false);
        changeCollision(p(2, 2), p(2, 1),'d', false);
        changeCollision(p(0, 4), p(2, 1),'d', false);
        changeCollision(p(0, 6), p(2, 1),'u', false);
        changeCollision(p(0, 6), p(2, 1),'r', false);
        changeCollision(p(2, 6), p(2, 1),'l', false);
        changeCollision(p(2, 6), p(2, 1),'r', false);
        changeCollision(p(4, 6), p(2, 1),'l', false);
        changeCollision(p(4, 6), p(2, 1),'r', false);
        changeCollision(p(6, 6), p(2, 1),'l', false);
        changeCollision(p(1, 5), p(2, 1),'d', false);
        changeCollision(p(1, 5), p(2, 1),'r', false);
        changeCollision(p(3, 5), p(2, 1),'l', false);
        changeCollision(p(4, 2), p(2, 1),'r', false);
        changeCollision(p(5, 1), p(2, 1),'d', false);
        changeCollision(p(5, 1), p(2, 1),'u', false);
        changeCollision(p(6, 0), p(2, 1),'l', false);
        changeCollision(p(6, 0), p(2, 1),'d', false);
        changeCollision(p(6, 2), p(2, 1),'l', false);
        changeCollision(p(6, 2), p(2, 1),'d', false);
        changeCollision(p(5, 3), p(2, 1),'l', false);
        changeCollision(p(5, 3), p(2, 1),'d', false);
        changeCollision(p(6, 4), p(2, 1),'u', false);

        // Obstacles
    }
    public static void pos2_4 () {
        // Exits
        MazeBoard.get(3, 1).getCell(6, 3).acceptTeleport(p(4, 1), 'r');
        MazeBoard.get(4, 1).getCell(0, 3).acceptTeleport(p(3, 1), 'l');
        changeCollision(p(6, 3), p(3, 1),'r', false);
        changeCollision(p(0, 3), p(4, 1),'l', false);

        // Down exit
        MazeBoard.get(3, 1).getCell(5, 6).acceptTeleport(p(3, 2), 'd');
        MazeBoard.get(3, 2).getCell(5, 0).acceptTeleport(p(3, 1), 'u');
        changeCollision(p(5, 6), p(3, 1),'d', false);
        changeCollision(p(5, 0), p(3, 2),'u', false);

        // Items
        MazeBoard.get(3, 1).getCell(2, 2).acceptItem(ItemDirectory.getItem(13));

        // Machines

        // Cutscenes
        MazeBoard.get(3, 1).getCell(1, 5).acceptCutscene(new Cutscene(new String[]{"HEY YOU!!!", "Yes it's the guard.", "Why'd you burn down that tree?", "Give me something to help regrow it."}));

        // "Correct" path first
        changeCollision(p(1, 5), p(3, 1),'l', false);
        changeCollision(p(1, 5), p(3, 1),'u', false);
        changeCollision(p(2, 4), p(3, 1),'l', false);
        changeCollision(p(2, 4), p(3, 1),'r', false);
        changeCollision(p(4, 4), p(3, 1),'l', false);
        changeCollision(p(4, 4), p(3, 1),'u', false);
        changeCollision(p(4, 2), p(3, 1),'d', false);
        changeCollision(p(4, 2), p(3, 1),'l', false);
        changeCollision(p(3, 1), p(3, 1),'d', false);
        changeCollision(p(3, 1), p(3, 1),'u', false);
        changeCollision(p(4, 0), p(3, 1),'l', false);
        changeCollision(p(4, 0), p(3, 1),'r', false);
        changeCollision(p(6, 0), p(3, 1),'l', false);
        changeCollision(p(6, 0), p(3, 1),'d', false);
        changeCollision(p(6, 2), p(3, 1),'u', false);
        changeCollision(p(6, 2), p(3, 1),'l', false);
        changeCollision(p(5, 3), p(3, 1),'u', false);
        changeCollision(p(5, 3), p(3, 1),'r', false);
        changeCollision(p(4, 4), p(3, 1),'d', false);
        changeCollision(p(5, 5), p(3, 1),'l', false);
        changeCollision(p(5, 5), p(3, 1),'d', false);

        // Misleading paths
        changeCollision(p(1, 5), p(3, 1),'d', false);
        changeCollision(p(0, 6), p(3, 1),'r', false);
        changeCollision(p(0, 4), p(3, 1),'r', false);
        changeCollision(p(0, 4), p(3, 1),'u', false);
        changeCollision(p(0, 2), p(3, 1),'d', false);
        changeCollision(p(3, 5), p(3, 1),'r', false);
        changeCollision(p(3, 5), p(3, 1),'l', false);
        changeCollision(p(2, 6), p(3, 1),'u', false);
        changeCollision(p(2, 6), p(3, 1),'r', false);
        changeCollision(p(4, 6), p(3, 1),'l', false);
        changeCollision(p(3, 3), p(3, 1),'r', false);
        changeCollision(p(3, 3), p(3, 1),'l', false);
        changeCollision(p(1, 3), p(3, 1),'r', false);
        changeCollision(p(1, 3), p(3, 1),'u', false);
        changeCollision(p(2, 2), p(3, 1),'l', false);
        changeCollision(p(3, 1), p(3, 1),'l', false);
        changeCollision(p(2, 0), p(3, 1),'d', false);
        changeCollision(p(2, 0), p(3, 1),'l', false);
        changeCollision(p(1, 1), p(3, 1),'r', false);
        changeCollision(p(1, 1), p(3, 1),'l', false);
        changeCollision(p(0, 0), p(3, 1),'d', false);
        changeCollision(p(5, 1), p(3, 1),'r', false);
        changeCollision(p(5, 1), p(3, 1),'l', false);
        changeCollision(p(5, 3), p(3, 1),'d', false);
        changeCollision(p(6, 4), p(3, 1),'l', false);
        changeCollision(p(6, 4), p(3, 1),'d', false);
        changeCollision(p(6, 6), p(3, 1),'u', false);

        // Obstacles
        MazeBoard.get(3, 1).getCell(5, 6).acceptObstacle(ObstacleDirectory.getObstacle(2), p(3, 1), p(5, 6), 'u');
    }
    public static void pos2_5 () {
        // Exits

        // Items
        MazeBoard.get(4, 1).getCell(4, 3).acceptItem(ItemDirectory.getItem(10));

        // Machines

        // Cutscenes
        MazeBoard.get(4, 1).getCell(1, 3).acceptCutscene(new Cutscene(new String[]{"Normally you need machinery and protection", "to make ammonium nitrate from", "ammonia and nitric acid.", "But not in this world.", "You can just mix it together."}));

        // "Correct" path first
        changeCollision(p(1, 3), p(4, 1),'l', false);
        changeCollision(p(1, 3), p(4, 1),'d', false);
        changeCollision(p(1, 5), p(4, 1),'u', false);
        changeCollision(p(1, 5), p(4, 1),'r', false);
        changeCollision(p(3, 5), p(4, 1),'l', false);
        changeCollision(p(3, 5), p(4, 1),'d', false);
        changeCollision(p(4, 6), p(4, 1),'l', false);
        changeCollision(p(4, 6), p(4, 1),'r', false);
        changeCollision(p(5, 5), p(4, 1),'d', false);
        changeCollision(p(5, 5), p(4, 1),'u', false);
        changeCollision(p(5, 3), p(4, 1),'d', false);
        changeCollision(p(5, 3), p(4, 1),'u', false);
        changeCollision(p(5, 1), p(4, 1),'d', false);
        changeCollision(p(5, 1), p(4, 1),'l', false);
        changeCollision(p(3, 1), p(4, 1),'r', false);
        changeCollision(p(3, 1), p(4, 1),'l', false);
        changeCollision(p(2, 2), p(4, 1),'u', false);
        changeCollision(p(2, 2), p(4, 1),'d', false);
        changeCollision(p(3, 3), p(4, 1),'l', false);
        changeCollision(p(3, 3), p(4, 1),'r', false);

        // Misleading paths
        changeCollision(p(1, 3), p(4, 1),'u', false);
        changeCollision(p(0, 2), p(4, 1),'r', false);
        changeCollision(p(0, 2), p(4, 1),'u', false);
        changeCollision(p(0, 0), p(4, 1),'d', false);
        changeCollision(p(0, 4), p(4, 1),'r', false);
        changeCollision(p(0, 4), p(4, 1),'d', false);
        changeCollision(p(0, 6), p(4, 1),'u', false);
        changeCollision(p(0, 6), p(4, 1),'r', false);
        changeCollision(p(2, 6), p(4, 1),'l', false);
        changeCollision(p(4, 6), p(4, 1),'u', false);
        changeCollision(p(4, 4), p(4, 1),'d', false);
        changeCollision(p(4, 4), p(4, 1),'l', false);
        changeCollision(p(5, 5), p(4, 1),'r', false);
        changeCollision(p(6, 6), p(4, 1),'u', false);
        changeCollision(p(4, 2), p(4, 1),'r', false);
        changeCollision(p(4, 2), p(4, 1),'l', false);
        changeCollision(p(5, 1), p(4, 1),'r', false);
        changeCollision(p(6, 0), p(4, 1),'d', false);
        changeCollision(p(6, 0), p(4, 1),'l', false);
        changeCollision(p(4, 0), p(4, 1),'r', false);
        changeCollision(p(6, 2), p(4, 1),'u', false);
        changeCollision(p(6, 2), p(4, 1),'d', false);
        changeCollision(p(6, 4), p(4, 1),'u', false);
        changeCollision(p(1, 1), p(4, 1),'r', false);
        changeCollision(p(1, 1), p(4, 1),'u', false);
        changeCollision(p(2, 0), p(4, 1),'l', false);
        changeCollision(p(2, 0), p(4, 1),'r', false);
        changeCollision(p(2, 4), p(4, 1),'r', false);

        // Obstacles
    }
    public static void pos3_4 () {
        // Exits
        MazeBoard.get(p(3, 2)).getCell(6, 6).acceptTeleport(p(4, 2), 'r');
        MazeBoard.get(p(4, 2)).getCell(0, 6).acceptTeleport(p(3, 2), 'l');
        changeCollision(p(6, 6), p(3, 2),'r', false);
        changeCollision(p(0, 6), p(4, 2),'l', false);

        // Left exit
        MazeBoard.get(p(2, 2)).getCell(6, 3).acceptTeleport(p(3, 2), 'r');
        MazeBoard.get(p(3, 2)).getCell(0, 3).acceptTeleport(p(2, 2), 'l');
        changeCollision(p(0, 3), p(3, 2),'l', false);
        changeCollision(p(6, 3), p(2, 2),'r', false);

        // Items

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(5, 1), p(3, 2),'u', false);
        changeCollision(p(5, 1), p(3, 2),'l', false);
        changeCollision(p(3, 1), p(3, 2),'r', false);
        changeCollision(p(3, 1), p(3, 2),'l', false);
        changeCollision(p(2, 2), p(3, 2),'u', false);
        changeCollision(p(2, 2), p(3, 2),'l', false);
        changeCollision(p(1, 3), p(3, 2),'u', false);
        changeCollision(p(1, 3), p(3, 2),'l', false);
        changeCollision(p(2, 2), p(3, 2),'d', false);
        changeCollision(p(2, 4), p(3, 2),'u', false);
        changeCollision(p(2, 4), p(3, 2),'d', false);
        changeCollision(p(3, 5), p(3, 2),'l', false);
        changeCollision(p(3, 5), p(3, 2),'r', false);
        changeCollision(p(4, 6), p(3, 2),'u', false);
        changeCollision(p(4, 6), p(3, 2),'r', false);
        changeCollision(p(6, 6), p(3, 2),'l', false);

        // Misleading paths
        changeCollision(p(5, 1), p(3, 2),'r', false);
        changeCollision(p(6, 0), p(3, 2),'d', false);
        changeCollision(p(6, 2), p(3, 2),'u', false);
        changeCollision(p(6, 2), p(3, 2),'l', false);
        changeCollision(p(6, 2), p(3, 2),'d', false);
        changeCollision(p(4, 2), p(3, 2),'r', false);
        changeCollision(p(6, 4), p(3, 2),'u', false);
        changeCollision(p(4, 0), p(3, 2),'d', false);
        changeCollision(p(4, 0), p(3, 2),'l', false);
        changeCollision(p(2, 0), p(3, 2),'r', false);
        changeCollision(p(1, 1), p(3, 2),'r', false);
        changeCollision(p(1, 1), p(3, 2),'u', false);
        changeCollision(p(0, 0), p(3, 2),'r', false);
        changeCollision(p(1, 1), p(3, 2),'l', false);
        changeCollision(p(0, 2), p(3, 2),'u', false);
        changeCollision(p(2, 4), p(3, 2),'l', false);
        changeCollision(p(0, 4), p(3, 2),'r', false);
        changeCollision(p(0, 4), p(3, 2),'d', false);
        changeCollision(p(0, 6), p(3, 2),'u', false);
        changeCollision(p(0, 6), p(3, 2),'r', false);
        changeCollision(p(1, 5), p(3, 2),'d', false);
        changeCollision(p(2, 6), p(3, 2),'u', false);
        changeCollision(p(2, 6), p(3, 2),'r', false);
        changeCollision(p(2, 4), p(3, 2),'r', false);
        changeCollision(p(4, 4), p(3, 2),'l', false);
        changeCollision(p(4, 4), p(3, 2),'r', false);
        changeCollision(p(5, 3), p(3, 2),'d', false);
        changeCollision(p(5, 3), p(3, 2),'l', false);
        changeCollision(p(3, 3), p(3, 2),'r', false);
        changeCollision(p(3, 3), p(3, 2),'u', false);
        changeCollision(p(5, 5), p(3, 2),'u', false);
        changeCollision(p(5, 5), p(3, 2),'r', false);

        // Obstacles
        MazeBoard.get(3, 2).getCell(0, 3).acceptObstacle(ObstacleDirectory.getObstacle(3), p(3, 2), p(0, 3), 'u');
    }
    public static void pos3_5 () {
        // Exits (None because this is a one way path)

        // Items
        MazeBoard.get(4, 2).getCell(3, 3).acceptItem(ItemDirectory.getItem(12));

        // Machines

        // Cutscenes
        MazeBoard.get(4, 2).getCell(1, 6).acceptCutscene(new Cutscene(new String[]{"This is going to be long..."}));

        // "Correct" path first
        changeCollision(p(0, 6), p(4, 2),'r', false);
        changeCollision(p(2, 6), p(4, 2),'l', false);
        changeCollision(p(2, 6), p(4, 2),'r', false);
        changeCollision(p(4, 6), p(4, 2),'l', false);
        changeCollision(p(4, 6), p(4, 2),'r', false);
        changeCollision(p(6, 6), p(4, 2),'l', false);
        changeCollision(p(6, 6), p(4, 2),'u', false);
        changeCollision(p(6, 4), p(4, 2),'d', false);
        changeCollision(p(6, 4), p(4, 2),'u', false);
        changeCollision(p(6, 2), p(4, 2),'d', false);
        changeCollision(p(6, 2), p(4, 2),'u', false);
        changeCollision(p(6, 0), p(4, 2),'d', false);
        changeCollision(p(6, 0), p(4, 2),'l', false);
        changeCollision(p(4, 0), p(4, 2),'r', false);
        changeCollision(p(4, 0), p(4, 2),'l', false);
        changeCollision(p(2, 0), p(4, 2),'r', false);
        changeCollision(p(2, 0), p(4, 2),'l', false);
        changeCollision(p(0, 0), p(4, 2),'r', false);
        changeCollision(p(0, 0), p(4, 2),'d', false);
        changeCollision(p(0, 2), p(4, 2),'u', false);
        changeCollision(p(0, 2), p(4, 2),'d', false);
        changeCollision(p(0, 4), p(4, 2),'u', false);
        changeCollision(p(0, 4), p(4, 2),'d', false);
        changeCollision(p(1, 5), p(4, 2),'l', false);
        changeCollision(p(1, 5), p(4, 2),'r', false);
        changeCollision(p(3, 5), p(4, 2),'l', false);
        changeCollision(p(3, 5), p(4, 2),'r', false);
        changeCollision(p(5, 5), p(4, 2),'l', false);
        changeCollision(p(5, 5), p(4, 2),'u', false);
        changeCollision(p(5, 3), p(4, 2),'d', false);
        changeCollision(p(5, 3), p(4, 2),'u', false);
        changeCollision(p(5, 1), p(4, 2),'d', false);
        changeCollision(p(5, 1), p(4, 2),'l', false);
        changeCollision(p(3, 1), p(4, 2),'r', false);
        changeCollision(p(3, 1), p(4, 2),'l', false);
        changeCollision(p(1, 1), p(4, 2),'r', false);
        changeCollision(p(1, 1), p(4, 2),'d', false);
        changeCollision(p(1, 3), p(4, 2),'u', false);
        changeCollision(p(1, 3), p(4, 2),'d', false);
        changeCollision(p(2, 4), p(4, 2),'l', false);
        changeCollision(p(2, 4), p(4, 2),'r', false);
        changeCollision(p(4, 4), p(4, 2),'l', false);
        changeCollision(p(4, 4), p(4, 2),'u', false);
        changeCollision(p(4, 2), p(4, 2),'l', false);
        changeCollision(p(4, 2), p(4, 2),'d', false);
        changeCollision(p(2, 2), p(4, 2),'r', false);
        changeCollision(p(2, 2), p(4, 2),'d', false);
        changeCollision(p(3, 3), p(4, 2),'l', false);

        // Misleading paths
        // None! Thank god

        // Obstacles

    }
    public static void pos3_3 () {
        // Exits
        MazeBoard.get(p(1, 2)).getCell(6, 2).acceptTeleport(p(2, 2), 'r');
        MazeBoard.get(p(2, 2)).getCell(0, 2).acceptTeleport(p(1, 2), 'l');
        changeCollision(p(6, 2), p(1, 2),'r', false);
        changeCollision(p(0, 2), p(2, 2),'l', false);

        // Items
        MazeBoard.get(2, 2).getCell(0, 6).acceptItem(ItemDirectory.getItem(20));

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(5, 3), p(2, 2),'r', false);
        changeCollision(p(5, 3), p(2, 2),'u', false);
        changeCollision(p(5, 1), p(2, 2),'d', false);
        changeCollision(p(5, 1), p(2, 2),'l', false);
        changeCollision(p(4, 2), p(2, 2),'u', false);
        changeCollision(p(4, 2), p(2, 2),'l', false);
        changeCollision(p(2, 2), p(2, 2),'r', false);
        changeCollision(p(2, 2), p(2, 2),'l', false);
        changeCollision(p(0, 2), p(2, 2),'r', false);

        // Misleading paths
        changeCollision(p(5, 3), p(2, 2),'d', false);
        changeCollision(p(6, 4), p(2, 2),'l', false);
        changeCollision(p(6, 4), p(2, 2),'d', false);
        changeCollision(p(6, 2), p(2, 2),'l', false);
        changeCollision(p(6, 2), p(2, 2),'u', false);
        changeCollision(p(6, 0), p(2, 2),'d', false);
        changeCollision(p(6, 0), p(2, 2),'l', false);
        changeCollision(p(4, 0), p(2, 2),'d', false);
        changeCollision(p(4, 0), p(2, 2),'l', false);
        changeCollision(p(3, 1), p(2, 2),'u', false);
        changeCollision(p(3, 1), p(2, 2),'l', false);
        changeCollision(p(2, 0), p(2, 2),'r', false);
        changeCollision(p(2, 0), p(2, 2),'l', false);
        changeCollision(p(1, 1), p(2, 2),'u', false);
        changeCollision(p(1, 1), p(2, 2),'l', false);
        changeCollision(p(0, 0), p(2, 2),'d', false);
        changeCollision(p(3, 3), p(2, 2),'u', false);
        changeCollision(p(3, 3), p(2, 2),'d', false);
        changeCollision(p(3, 5), p(2, 2),'u', false);
        changeCollision(p(3, 5), p(2, 2),'r', false);
        changeCollision(p(4, 4), p(2, 2),'d', false);
        changeCollision(p(4, 4), p(2, 2),'u', false);
        changeCollision(p(5, 5), p(2, 2),'l', false);
        changeCollision(p(5, 5), p(2, 2),'d', false);
        changeCollision(p(4, 6), p(2, 2),'r', false);
        changeCollision(p(4, 6), p(2, 2),'l', false);
        changeCollision(p(6, 6), p(2, 2),'l', false);
        changeCollision(p(2, 6), p(2, 2),'r', false);
        changeCollision(p(2, 2), p(2, 2),'d', false);
        changeCollision(p(1, 3), p(2, 2),'r', false);
        changeCollision(p(1, 3), p(2, 2),'l', false);
        changeCollision(p(0, 4), p(2, 2),'u', false);
        changeCollision(p(1, 3), p(2, 2),'d', false);
        changeCollision(p(2, 4), p(2, 2),'l', false);
        changeCollision(p(2, 4), p(2, 2),'d', false);
        changeCollision(p(1, 5), p(2, 2),'u', false);
        changeCollision(p(1, 5), p(2, 2),'l', false);
        changeCollision(p(0, 6), p(2, 2),'u', false);
        changeCollision(p(2, 6), p(2, 2),'l', false);

        // Obstacles

    }
    public static void pos3_2 () {
        // Exits
        MazeBoard.get(1, 2).getCell(0, 3).acceptTeleport(p(0, 2), 'l');
        changeCollision(p(0, 3), p(1, 2),'l', false);

        // Up exit
        MazeBoard.get(1, 1).getCell(3, 6).acceptTeleport(p(1, 2), 'd');
        MazeBoard.get(1, 2).getCell(3, 0).acceptTeleport(p(1, 1), 'u');
        changeCollision(p(3, 0), p(1, 2),'u', false);
        changeCollision(p(3, 6), p(1, 1),'d', false);

        // Items

        // Machines
        try {
            MazeBoard.get(1, 2).getCell(2, 1).acceptMachine(new Machine("Resources/images/creammachine.jpeg", "Cream machine"));
            // MazeBoard.get(1, 2).getCell(2, 1).accessMachine().addRecipe();
            MazeBoard.get(1, 2).getCell(2, 1).accessMachine().addRecipe(13, new Cutscene(new String[]{"Maybe if it were a powder..."}));
            MazeBoard.get(1, 2).getCell(2, 1).accessMachine().addRecipe(15, ItemDirectory.getItem(16));
        } catch (Exception ignored) {

        }

        // Cutscenes
        MazeBoard.get(1, 2).getCell(5, 2).acceptCutscene(new Cutscene(new String[]{"Oh! It's a cream machine.", "You've wanted one since you were young.", "Though you don't know what to make...", "...now that you have it.", "It can make anything into a cream though...", "... if it's a powder or a liquid."}));

        // "Correct" path first
        changeCollision(p(6, 2), p(1, 2),'l', false);
        changeCollision(p(5, 3), p(1, 2),'u', false);
        changeCollision(p(5, 3), p(1, 2),'d', false);
        changeCollision(p(5, 5), p(1, 2),'u', false);
        changeCollision(p(5, 5), p(1, 2),'l', false);
        changeCollision(p(3, 5), p(1, 2),'r', false);
        changeCollision(p(3, 5), p(1, 2),'u', false);
        changeCollision(p(3, 3), p(1, 2),'d', false);
        changeCollision(p(3, 3), p(1, 2),'u', false);
        changeCollision(p(3, 1), p(1, 2),'d', false);
        changeCollision(p(3, 1), p(1, 2),'u', false);
        changeCollision(p(4, 6), p(1, 2),'u', false);
        changeCollision(p(4, 6), p(1, 2),'l', false);
        changeCollision(p(2, 6), p(1, 2),'r', false);
        changeCollision(p(2, 6), p(1, 2),'l', false);
        changeCollision(p(0, 6), p(1, 2),'r', false);
        changeCollision(p(0, 6), p(1, 2),'u', false);
        changeCollision(p(0, 4), p(1, 2),'d', false);
        changeCollision(p(0, 4), p(1, 2),'r', false);
        changeCollision(p(0, 4), p(1, 2),'d', false);

        // Misleading paths
        changeCollision(p(1, 3), p(1, 2),'d', false);
        changeCollision(p(4, 4), p(1, 2),'r', false);
        changeCollision(p(4, 4), p(1, 2),'u', false);
        changeCollision(p(4, 2), p(1, 2),'d', false);
        changeCollision(p(2, 2), p(1, 2),'r', false);
        changeCollision(p(2, 2), p(1, 2),'l', false);
        changeCollision(p(0, 2), p(1, 2),'r', false);
        changeCollision(p(0, 2), p(1, 2),'u', false);
        changeCollision(p(1, 1), p(1, 2),'l', false);
        changeCollision(p(1, 1), p(1, 2),'r', false);
        changeCollision(p(0, 0), p(1, 2),'d', false);
        changeCollision(p(0, 0), p(1, 2),'r', false);
        changeCollision(p(2, 0), p(1, 2),'l', false);
        changeCollision(p(3, 1), p(1, 2),'r', false);
        changeCollision(p(5, 1), p(1, 2),'l', false);
        changeCollision(p(5, 1), p(1, 2),'r', false);
        changeCollision(p(6, 0), p(1, 2),'d', false);
        changeCollision(p(6, 0), p(1, 2),'l', false);
        changeCollision(p(4, 0), p(1, 2),'r', false);
        changeCollision(p(4, 6), p(1, 2),'r', false);
        changeCollision(p(6, 6), p(1, 2),'l', false);
        changeCollision(p(6, 6), p(1, 2),'u', false);
        changeCollision(p(6, 4), p(1, 2),'d', false);
        changeCollision(p(6, 4), p(1, 2),'u', false);
        changeCollision(p(1, 5), p(1, 2),'l', false);
        changeCollision(p(1, 5), p(1, 2),'r', false);
        changeCollision(p(2, 4), p(1, 2),'d', false);
        changeCollision(p(2, 4), p(1, 2),'u', false);

        // Obstacles
        MazeBoard.get(1, 2).getCell(0, 3).acceptObstacle(ObstacleDirectory.getObstacle(5), p(1, 2), p(0, 3), 'd');
    }
    public static void pos2_2 () {
        // Exits
        MazeBoard.get(0, 1).getCell(6, 0).acceptTeleport(p(1, 1), 'r');
        MazeBoard.get(1, 1).getCell(0, 0).acceptTeleport(p(0, 1), 'l');
        changeCollision(p(6, 0), p(0, 1),'r', false);
        changeCollision(p(0, 0), p(1, 1),'l', false);

        // Items
        MazeBoard.get(1, 1).getCell(1, 6).acceptItem(ItemDirectory.getItem(14));

        // Machines

        // Cutscenes
        MazeBoard.get(1, 1).getCell(5, 2).acceptCutscene(new Cutscene(new String[]{"HEY!!", "Sorry to bother you again.", "But please put on sunscreen...", "...before going in there.", "UV index is SO HIGH there.", "You'll get sunburned in like 5 seconds."}));


        // "Correct" path first
        changeCollision(p(3, 5), p(1, 1),'d', false);
        changeCollision(p(3, 5), p(1, 1),'r', false);
        changeCollision(p(5, 5), p(1, 1),'l', false);
        changeCollision(p(5, 5), p(1, 1),'u', false);
        changeCollision(p(5, 3), p(1, 1),'d', false);
        changeCollision(p(5, 3), p(1, 1),'u', false);
        changeCollision(p(5, 1), p(1, 1),'d', false);
        changeCollision(p(5, 1), p(1, 1),'l', false);
        changeCollision(p(4, 2), p(1, 1),'u', false);
        changeCollision(p(4, 2), p(1, 1),'l', false);
        changeCollision(p(2, 2), p(1, 1),'r', false);
        changeCollision(p(2, 2), p(1, 1),'u', false);
        changeCollision(p(2, 0), p(1, 1),'d', false);
        changeCollision(p(2, 0), p(1, 1),'l', false);
        changeCollision(p(0, 0), p(1, 1),'r', false);

        // Misleading paths
        changeCollision(p(4, 6), p(1, 1),'u', false);
        changeCollision(p(4, 6), p(1, 1),'r', false);
        changeCollision(p(6, 6), p(1, 1),'l', false);
        changeCollision(p(6, 6), p(1, 1),'u', false);
        changeCollision(p(6, 4), p(1, 1),'d', false);
        changeCollision(p(4, 4), p(1, 1),'r', false);
        changeCollision(p(4, 4), p(1, 1),'l', false);
        changeCollision(p(3, 3), p(1, 1),'d', false);
        changeCollision(p(3, 3), p(1, 1),'r', false);
        changeCollision(p(5, 3), p(1, 1),'r', false);
        changeCollision(p(6, 2), p(1, 1),'d', false);
        changeCollision(p(6, 2), p(1, 1),'u', false);
        changeCollision(p(3, 1), p(1, 1),'d', false);
        changeCollision(p(3, 1), p(1, 1),'u', false);
        changeCollision(p(4, 0), p(1, 1),'l', false);
        changeCollision(p(4, 0), p(1, 1),'r', false);
        changeCollision(p(6, 0), p(1, 1),'l', false);
        changeCollision(p(2, 2), p(1, 1),'d', false);
        changeCollision(p(2, 4), p(1, 1),'u', false);
        changeCollision(p(2, 4), p(1, 1),'d', false);
        changeCollision(p(2, 6), p(1, 1),'u', false);
        changeCollision(p(2, 4), p(1, 1),'l', false);
        changeCollision(p(1, 5), p(1, 1),'u', false);
        changeCollision(p(1, 5), p(1, 1),'l', false);
        changeCollision(p(0, 6), p(1, 1),'u', false);
        changeCollision(p(0, 6), p(1, 1),'r', false);
        changeCollision(p(1, 1), p(1, 1),'r', false);
        changeCollision(p(1, 1), p(1, 1),'l', false);
        changeCollision(p(0, 2), p(1, 1),'u', false);
        changeCollision(p(0, 2), p(1, 1),'d', false);
        changeCollision(p(0, 4), p(1, 1),'u', false);
        changeCollision(p(0, 2), p(1, 1),'r', false);
        changeCollision(p(1, 3), p(1, 1),'u', false);

        // Obstacles
        MazeBoard.get(1, 1).getCell(0, 0).acceptObstacle(ObstacleDirectory.getObstacle(4), p(1, 1), p(0, 0), 'r');

    }
    public static void pos2_1 () {
        // Exits

        // Items
        MazeBoard.get(0, 1).getCell(4, 5).acceptItem(ItemDirectory.getItem(17));

        // Machines

        // Cutscenes

        // "Correct" path first
        changeCollision(p(6, 0), p(0, 1),'l', false);
        changeCollision(p(5, 1), p(0, 1),'u', false);
        changeCollision(p(5, 1), p(0, 1),'d', false);
        changeCollision(p(4, 2), p(0, 1),'r', false);
        changeCollision(p(4, 2), p(0, 1),'u', false);
        changeCollision(p(3, 1), p(0, 1),'r', false);
        changeCollision(p(3, 1), p(0, 1),'l', false);
        changeCollision(p(1, 1), p(0, 1),'r', false);
        changeCollision(p(1, 1), p(0, 1),'d', false);
        changeCollision(p(2, 2), p(0, 1),'l', false);
        changeCollision(p(2, 2), p(0, 1),'d', false);
        changeCollision(p(2, 4), p(0, 1),'u', false);
        changeCollision(p(2, 4), p(0, 1),'d', false);
        changeCollision(p(1, 5), p(0, 1),'r', false);
        changeCollision(p(1, 5), p(0, 1),'d', false);
        changeCollision(p(2, 6), p(0, 1),'l', false);
        changeCollision(p(2, 6), p(0, 1),'r', false);
        changeCollision(p(4, 6), p(0, 1),'l', false);
        changeCollision(p(4, 6), p(0, 1),'r', false);
        changeCollision(p(6, 6), p(0, 1),'l', false);
        changeCollision(p(6, 6), p(0, 1),'u', false);
        changeCollision(p(6, 4), p(0, 1),'d', false);
        changeCollision(p(6, 4), p(0, 1),'l', false);
        changeCollision(p(4, 4), p(0, 1),'r', false);

        // Misleading paths
        changeCollision(p(5, 1), p(0, 1),'r', false);
        changeCollision(p(6, 2), p(0, 1),'u', false);
        changeCollision(p(6, 2), p(0, 1),'d', false);
        changeCollision(p(5, 3), p(0, 1),'r', false);
        changeCollision(p(5, 3), p(0, 1),'l', false);
        changeCollision(p(4, 0), p(0, 1),'d', false);
        changeCollision(p(4, 0), p(0, 1),'l', false);
        changeCollision(p(1, 3), p(0, 1),'u', false);
        changeCollision(p(1, 3), p(0, 1),'l', false);
        changeCollision(p(0, 2), p(0, 1),'d', false);
        changeCollision(p(0, 2), p(0, 1),'u', false);
        changeCollision(p(0, 0), p(0, 1),'d', false);
        changeCollision(p(0, 0), p(0, 1),'r', false);
        changeCollision(p(2, 0), p(0, 1),'l', false);
        changeCollision(p(3, 5), p(0, 1),'l', false);
        changeCollision(p(3, 5), p(0, 1),'u', false);
        changeCollision(p(3, 3), p(0, 1),'d', false);
        changeCollision(p(3, 3), p(0, 1),'u', false);
        changeCollision(p(0, 6), p(0, 1),'r', false);
        changeCollision(p(0, 6), p(0, 1),'u', false);
        changeCollision(p(0, 4), p(0, 1),'d', false);
        changeCollision(p(0, 4), p(0, 1),'r', false);
        changeCollision(p(5, 5), p(0, 1),'r', false);
        changeCollision(p(5, 5), p(0, 1),'l', false);

        // Obstacles


    }
    public static void pos3_1 () {
        // Exits

        // Items

        // Machines
        try {
            MazeBoard.get(0, 2).getCell(3, 3).acceptMachine(new Machine("Resources/images/vendingmachine.jpeg", "Vending machine"));
            MazeBoard.get(0, 2).getCell(3, 3).accessMachine().addRecipe(20, "end");
        } catch (Exception ignored) {

        }

        // Cutscenes
        MazeBoard.get(0, 2).getCell(6, 3).acceptCutscene(new Cutscene(new String[]{"You can't go back now.", "Maybe put the coin in the machine..."}));

        // Clearing out all the boundaries
        changeCollision(p(0, 0), p(0, 2),'r', false);
        changeCollision(p(0, 0), p(0, 2),'d', false);
        changeCollision(p(0, 2), p(0, 2),'u', false);
        changeCollision(p(0, 2), p(0, 2),'r', false);
        changeCollision(p(0, 2), p(0, 2),'d', false);
        changeCollision(p(0, 4), p(0, 2),'u', false);
        changeCollision(p(0, 4), p(0, 2),'r', false);
        changeCollision(p(0, 4), p(0, 2),'d', false);
        changeCollision(p(0, 6), p(0, 2),'u', false);
        changeCollision(p(0, 6), p(0, 2),'r', false);
        changeCollision(p(0, 6), p(0, 2),'r', false);
        changeCollision(p(1, 1), p(0, 2),'u', false);
        changeCollision(p(1, 1), p(0, 2),'r', false);
        changeCollision(p(1, 1), p(0, 2),'d', false);
        changeCollision(p(1, 1), p(0, 2),'l', false);
        changeCollision(p(1, 3), p(0, 2),'u', false);
        changeCollision(p(1, 3), p(0, 2),'r', false);
        changeCollision(p(1, 3), p(0, 2),'d', false);
        changeCollision(p(1, 3), p(0, 2),'l', false);
        changeCollision(p(1, 5), p(0, 2),'u', false);
        changeCollision(p(1, 5), p(0, 2),'r', false);
        changeCollision(p(1, 5), p(0, 2),'d', false);
        changeCollision(p(1, 5), p(0, 2),'l', false);
        changeCollision(p(2, 0), p(0, 2),'r', false);
        changeCollision(p(2, 0), p(0, 2),'d', false);
        changeCollision(p(2, 0), p(0, 2),'l', false);
        changeCollision(p(2, 2), p(0, 2),'u', false);
        changeCollision(p(2, 2), p(0, 2),'r', false);
        changeCollision(p(2, 2), p(0, 2),'d', false);
        changeCollision(p(2, 2), p(0, 2),'l', false);
        changeCollision(p(2, 4), p(0, 2),'u', false);
        changeCollision(p(2, 4), p(0, 2),'r', false);
        changeCollision(p(2, 4), p(0, 2),'d', false);
        changeCollision(p(2, 4), p(0, 2),'l', false);
        changeCollision(p(2, 6), p(0, 2),'u', false);
        changeCollision(p(2, 6), p(0, 2),'r', false);
        changeCollision(p(2, 6), p(0, 2),'l', false);
        changeCollision(p(3, 1), p(0, 2),'u', false);
        changeCollision(p(3, 1), p(0, 2),'r', false);
        changeCollision(p(3, 1), p(0, 2),'d', false);
        changeCollision(p(3, 1), p(0, 2),'l', false);
        changeCollision(p(3, 3), p(0, 2),'u', false);
        changeCollision(p(3, 3), p(0, 2),'r', false);
        changeCollision(p(3, 3), p(0, 2),'d', false);
        changeCollision(p(3, 3), p(0, 2),'l', false);
        changeCollision(p(3, 5), p(0, 2),'u', false);
        changeCollision(p(3, 5), p(0, 2),'r', false);
        changeCollision(p(3, 5), p(0, 2),'d', false);
        changeCollision(p(3, 5), p(0, 2),'l', false);
        changeCollision(p(4, 0), p(0, 2),'r', false);
        changeCollision(p(4, 0), p(0, 2),'d', false);
        changeCollision(p(4, 0), p(0, 2),'l', false);
        changeCollision(p(4, 2), p(0, 2),'u', false);
        changeCollision(p(4, 2), p(0, 2),'r', false);
        changeCollision(p(4, 2), p(0, 2),'d', false);
        changeCollision(p(4, 2), p(0, 2),'l', false);
        changeCollision(p(4, 4), p(0, 2),'u', false);
        changeCollision(p(4, 4), p(0, 2),'r', false);
        changeCollision(p(4, 4), p(0, 2),'d', false);
        changeCollision(p(4, 4), p(0, 2),'l', false);
        changeCollision(p(4, 6), p(0, 2),'u', false);
        changeCollision(p(4, 6), p(0, 2),'r', false);
        changeCollision(p(4, 6), p(0, 2),'l', false);
        changeCollision(p(5, 1), p(0, 2),'u', false);
        changeCollision(p(5, 1), p(0, 2),'r', false);
        changeCollision(p(5, 1), p(0, 2),'d', false);
        changeCollision(p(5, 1), p(0, 2),'l', false);
        changeCollision(p(5, 3), p(0, 2),'u', false);
        changeCollision(p(5, 3), p(0, 2),'r', false);
        changeCollision(p(5, 3), p(0, 2),'d', false);
        changeCollision(p(5, 3), p(0, 2),'l', false);
        changeCollision(p(5, 5), p(0, 2),'u', false);
        changeCollision(p(5, 5), p(0, 2),'r', false);
        changeCollision(p(5, 5), p(0, 2),'d', false);
        changeCollision(p(5, 5), p(0, 2),'l', false);
        changeCollision(p(6, 0), p(0, 2),'d', false);
        changeCollision(p(6, 0), p(0, 2),'l', false);
        changeCollision(p(6, 2), p(0, 2),'u', false);
        changeCollision(p(6, 2), p(0, 2),'d', false);
        changeCollision(p(6, 2), p(0, 2),'l', false);
        changeCollision(p(6, 4), p(0, 2),'u', false);
        changeCollision(p(6, 4), p(0, 2),'d', false);
        changeCollision(p(6, 4), p(0, 2),'l', false);
        changeCollision(p(6, 6), p(0, 2),'u', false);
        changeCollision(p(6, 6), p(0, 2),'l', false);

        // Misleading paths

        // Obstacles

    }
}
