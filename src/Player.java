import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

/** Handles aspect of the player : possessions, positions, and the board that the player is on
 * @author Tyler Gu
 * @version 1.3 (1.2) Removed the enum class because it made messy code
 * @since 1.0
 */
public class Player {
    // Inventory, can hold 5 items
    private static ArrayList<Item> inventory = new ArrayList<>();
    // Positioning
    private static Position position = new Position(0, 6);
    private static Position board = new Position(0, 0);
    // This handles the direction that the player decides to face
    private static char f = 'u'; // Changed enum facing to char

    /**
     * "Flips" direction (or a 180 turn). u <--> d, r <--> l
     * @param f direction to be changed
     * @return direction after being flipped
     */
    public static char flipDirection (char f) {
        if (f== 'u') {
            return 'd';
        } else if (f== 'r') {
            return 'l';
        } else if (f == 'd') {
            return 'u';
        } else if (f == 'l') {
            return 'r';
        } else return 'u';
    }

    /**
     * Adds an item if there's less than 5
     * @param item the item to be added
     * @return If the item was added, it's true
     */
    public static boolean addItem (Item item) {
        if (inventory.size() < 4) {
            inventory.add(item);
            return true;
        }
        else {
            System.out.println("Inventory is full");
            return false;
        }
    }

    /**
     * Removes an item if present
     * @param item the item to be removed
     * @return if it was successful or not
     */
    public static boolean removeItem (Item item) {
        return inventory.remove(item);
    }

    // Gets item according to the key value
    public static Item getItem (int key) {
        return inventory.get(key);
    }

    /** Uses an item that the player specifies, onto the tile that is specified by the direction that the player faces
     * @param key the item to be used
     */
    public static void useItem (char key) {

            // This selects the cell that the item will be placed on.
            Position selectedCell;
            // Selects according to if the player is facing up and (there's no collision on the cell that one is on or (if the position according to the position has an obstacle and that cell's open direction is the opposite of the player's facing value))
            if ((f == 'u' && (position.getY() != 0 && !MazeBoard.get(board).getCell(position).returnCollision('u'))) || MazeBoard.get(board).getCell(position.getX(), position.getY()-1).hasObstacle() && flipDirection(f) == MazeBoard.get(board).getCell(position.getX(), position.getY()-1).getOpenDir()) {
                selectedCell = new Position(position.getX(), position.getY()-1);
            } else if ((f == 'r' && (position.getX() != MazeBoard.getUnitSize() - 1 && !MazeBoard.get(board).getCell(position).returnCollision('r'))) || MazeBoard.get(board).getCell(position.getX()+1, position.getY()).hasObstacle() && flipDirection(f) == MazeBoard.get(board).getCell(position.getX()+1, position.getY()).getOpenDir()) {
                selectedCell = new Position(position.getX()+1, position.getY());
            } else if ((f == 'd' && (position.getY() != MazeBoard.getUnitSize() - 1 && !MazeBoard.get(board).getCell(position).returnCollision('d'))) || MazeBoard.get(board).getCell(position.getX(), position.getY()+1).hasObstacle() && flipDirection(f) == MazeBoard.get(board).getCell(position.getX(), position.getY()+1).getOpenDir()) {
                selectedCell = new Position(position.getX(), position.getY()+1);
            } else if ((f == 'l' && position.getX() != 0 && !MazeBoard.get(board).getCell(position).returnCollision('l')) || MazeBoard.get(board).getCell(position.getX()-1, position.getY()-1).hasObstacle() && flipDirection(f) == MazeBoard.get(board).getCell(position.getX()-1, position.getY()).getOpenDir()) {
                selectedCell = new Position(position.getX()-1, position.getY());
            } else { // If there's something blocking the player (collision) then the selectedCell is the value of the player
                selectedCell = position;
            }

            // This adds extra insurance because sometimes it gets finicky around corners
            if (!MazeBoard.get(board).getCell(position).returnCollision(f) || MazeBoard.get(board).getCell(selectedCell).hasObstacle()) {
                MazeBoard.get(board).getCell(selectedCell).itemUsed(getItem(key - 49), selectedCell);
            } else {
                MazeBoard.get(board).getCell(position).itemUsed(getItem(key-49), position);
            }

    }

    // Gets the position of the player
    public static Position getPosition () {
        return position;
    }

    // Gets the board of the player
    public static Position getBoard () {
        return board;
    }

    /**
     * Moves the player according to dir
     * @param dir Direction to move
     */
    public static void movePlayer (char dir) {
        change(dir);
        if (!MazeBoard.get(board.getX(), board.getY()).getCell(position.getX(), position.getY())
                .returnCollision(dir)) {
            position.move(dir, MazeBoard.getUnitSize()-1);
            MazeBoard.get(board.getX(), board.getY()).getCell(Player.getPosition().getX(), Player.getPosition().getY()).overlap();

        }
    }

    /**
     * Changes the way that the player is facing using dir
     * @param dir direction to change to
     */
    public static void change (char dir) {
        f = dir;
    }

    /** Changes board, and changes position as if it's just landing from that place (if going right, x = 6 changes to x = 0 after the board change)
     * @param pos Board to change to
     * @param dir Direction of the board change
     */
    public static void changeBoard (Position pos, char dir) {
        board = pos;
        if (dir == 'u') {
            position = new Position(position.getX(), MazeBoard.getUnitSize() - 1);
        } else if (dir == 'r') {
            position = new Position(0, position.getY());
        } else if (dir == 'd') {
            position = new Position(position.getX(), 0);
        } else if (dir == 'l') {
            position = new Position(MazeBoard.getUnitSize() - 1, position.getY());

        }
    }

    /** Draws the player as a black circle
     * @param scale Scale
     * @param pen GraphicsContext to draw in
     * */
    public static void drawPlayer(int scale, GraphicsContext pen) {
        pen.setFill(Color.BLACK);
        pen.fillOval(position.getX() * scale + 130, position.getY() * scale + 80, scale*0.8, scale*0.8);
    }

    /** Draws the player's inventory
     * @param pen GraphicsContext to draw in
     * @param itemSelected item that the mouse is hovering over
     */
    public static void drawInventory(GraphicsContext pen, int itemSelected) {
        switch (itemSelected) { // Fills in the box with yellow if the item is selected
            case 0:
                pen.setFill(Color.YELLOW);
                pen.fillRect(100, 500, 80, 90);
                break;
            case 1:
                pen.setFill(Color.YELLOW);
                pen.fillRect(180, 500, 80, 90);
                break;
            case 2:
                pen.setFill(Color.YELLOW);
                pen.fillRect(260, 500, 80, 90);
                break;
            case 3:
                pen.setFill(Color.YELLOW);
                pen.fillRect(340, 500, 80, 90);
                break;
            case 4:
                pen.setFill(Color.YELLOW);
                pen.fillRect(420, 500, 80, 90);
                break;
            default:
                break;
        }

        // Draws the lines
        pen.setStroke(Color.BLACK);
        pen.strokeRect(100, 500, 400, 90);
        pen.strokeLine(180, 500, 180, 590);
        pen.strokeLine(260, 500, 260, 590);
        pen.strokeLine(340, 500, 340, 590);
        pen.strokeLine(420, 500, 420, 590);
        pen.setFont(Font.font("Helvetica", 12));

        // draws the numbers
        pen.setFill(Color.BLACK);
        pen.fillText("1", 140, 585);
        pen.fillText("2", 220, 585);
        pen.fillText("3", 300, 585);
        pen.fillText("4", 380, 585);
        pen.fillText("5", 460, 585);



        // Draws the inventory images
        for (int x = 0; x != inventory.size(); x++) {
            pen.drawImage(inventory.get(x).getImage(), x*80 + 105, 505, 70, 70);
        }
    }
}
