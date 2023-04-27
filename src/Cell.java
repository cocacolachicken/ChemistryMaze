import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** Individual building blocks of the game
 * @author Tyler Gu
 * @version 1.3
 * @since 1.0
 */
public class Cell {
    private boolean[] collision = new boolean[4]; // URDL collision
    // Next ones store "special" stuff that can be on cells — cutscenes, items, obstacles, teleport, machine
    // Obstacle and teleport also have two values — dir and opendir to assist with functions of them. I feel like it's much better organized in this class.
    private Cutscene cutscene;
    private Item item;
    private Obstacle obstacle;
    private char openDir; // If an obstacle gets destroyed, this stores which cell opens up
    private Position teleport;
    private char dir;
    private Machine machine;

    // Constructor: Makes a cell with all true collisions. This helps with making mazes to be honest
    public Cell () {
        // URDL/clockwise direction hitbox representation
        collision[0] = true;
        collision[1] = true;
        collision[2] = true;
        collision[3] = true;
    }

    /**
     * changeCollision
     * Changes collision of a given cell and direction
     * @param c which direction the collision is being changed
     * @param b value for which the collision is turning into
     * @param board if this is provided, then the cell next to it according to c according to is changed. this value provides the location of the cell
     * @param position  ^^^
     */
    public void changeCollision (char c, boolean b, Position board, Position position) {
        if (c == 'u') {
            this.collision[0] = b;
            if (position.getY() != 0) {
                MazeBoard.get(board).getCell(position.getX(), position.getY() - 1).changeCollision('d', b);
            }
        } else if (c == 'r') {
            this.collision[1] = b;
            if (position.getX() != 6) {
                MazeBoard.get(board).getCell(position.getX() + 1, position.getY()).changeCollision('l', b);
            }
        } else if (c == 'd') {
            this.collision[2] = b;
            if (position.getY() != 6) {
                MazeBoard.get(board).getCell(position.getX(), position.getY() + 1).changeCollision('u', b);
            }
        } else if (c == 'l') {
            this.collision[3] = b;
            if (position.getX() != 0) {
                MazeBoard.get(board).getCell(position.getX() - 1, position.getY()).changeCollision('r', b);
            }
        }
    }
    public void changeCollision (char c, boolean b) {
        if (c == 'u') {
            this.collision[0] = b;
        } else if (c == 'r') {
            this.collision[1] = b;
        } else if (c == 'd') {
            this.collision[2] = b;
        } else if (c == 'l') {
            this.collision[3] = b;
        }
    }

    // "Has" thing
    public boolean hasItem () {
        return item != null;
    }
    public boolean hasCutscene () {
        return cutscene != null;
    }
    public boolean hasObstacle () {return obstacle !=null;}
    public boolean hasTeleport () {return teleport != null;}
    public boolean hasMachine () {
        return machine != null;
    }

    // Returns collision of the cell
    public boolean returnCollision (char s) {
        if (s == 'u') {
            return collision[0];
        }
        if (s == 'r') {
            return collision[1];
        }
        if (s == 'd') {
            return collision[2];
        }
        if (s == 'l') {
            return collision[3];
        }
        return false;
    }

    // Setters. Obstacle's is special because of parameters that get stored in the cell.
    public void acceptItem (Item i) {
        item = i;
    }
    /**
     * acceptObstacle
     * Accepts an obstacle into possesion and changes collision accordingly
     * @param o the obstacle being placed on the cell
     * @param board the board that the cell is on
     * @param p the position that the cell is on on the board
     * @param oD the direction that opens when the obstacle is gone
     */
    public void acceptObstacle (Obstacle o, Position board, Position p, char oD) {
        obstacle = o;
        openDir = oD;
        if (dir != 'u') {
            MazeBoard.get(board).getCell(p).changeCollision('u', true);
        }
        if (dir != 'r') {
            MazeBoard.get(board).getCell(p).changeCollision('r', true);
        }
        if (dir != 'd') {
            MazeBoard.get(board).getCell(p).changeCollision('d', true);
        }
        if (dir != 'l') {
            MazeBoard.get(board).getCell(p).changeCollision('l', true);
        }
        try {
            MazeBoard.get(board).getCell(p.getX(), p.getY()-1).changeCollision('d', true, board, p);
        } catch (Exception ignored) {
        }
        try {
            MazeBoard.get(board).getCell(p.getX() - 1, p.getY()).changeCollision('r', true, board, p);
        } catch (Exception ignored) {
        }
        try {
            MazeBoard.get(board).getCell(p.getX(), p.getY()+1).changeCollision('u', true, board, p);
        } catch (Exception ignored) {
        }
        try { // This one is the only one where it's being implemented correctly
            MazeBoard.get(board).getCell(p.getX()+1, p.getY()).changeCollision('l', true, board, p);
        } catch (Exception ignored) {
        }
    }
    public void acceptTeleport (Position p, char c) {
        teleport = p;
        dir = c;
    }
    public void acceptCutscene (Cutscene c) {
        cutscene = c;
    }
    public void acceptMachine (Machine m) {
        machine = m;
    }

    // Accessor for machine and the open direction
    public Machine accessMachine () {
        return machine;
    }
    public char getOpenDir () {
        return openDir;
    }

    /**
     * overlap
     * Method that runs to check for collision with any items, obstacles, teleports, etc and acts accordingly
     */
    public void overlap () {
        if (hasItem()) {
            pickupItem();
        } else if (hasCutscene()) {
            cueCutscene();
        } else if (hasTeleport()) {

            activateTeleport();
            System.out.println("Teleporting to board " + teleport.getX() + ", " + teleport.getY() + " cell ");
        }
    }

    /**
     * itemUsed
     * Acts according to i and the special thing that the cell carries
     * @param i item being used
     * @param p position of the cell
     */
    public void itemUsed (Item i, Position p) {
        if (hasObstacle()) { // If there's an obstacle it tries to use the item ont he obstacle
            System.out.println("Using " + i.getName());
            destroyObstacle(i, p, Player.getBoard());
        } else if (hasMachine()) { // If there's a machine it tries to use it on the machine
            if (machine.craft(i) != null) { // If there is a result
                if (machine.craft(i).getClass() == Item.class) { // If there's a machine it follows either the "crafter" (here)
                    Game.cueCutscene(new Cutscene(new String[]{machine.getName() + " turned " + i.getName(), "into " + ((Item) machine.craft(i)).getName()}));
                    Player.removeItem(i);
                    Player.addItem((Item) machine.craft(i));
                } else if (machine.craft(i).getClass() == Cutscene.class) { // "Cutscene" which doesn't consume the item
                    Game.cueCutscene((Cutscene) machine.craft(i));
                } else if (machine.craft(i).getClass() == String.class) { // Or ends the game (only in the coin with vending machine)
                    Game.endGame();
                }
            }
        } else {
            System.out.println("Dropping " + i.getName()); // Else, Drops item on the "empty" tile
            if (!hasItem()) { // If there isn't an item the tile just gets it
                acceptItem(i);
                Player.removeItem(i);
            } else { // but if there is it crafts if there's a recipe
                System.out.println("Item not dropped, trying to craft");
                if (Crafter.craft(item, i) != null) {
                    Player.removeItem(i);
                    Player.addItem(Crafter.craft(item, i));
                    Game.cueCutscene(new Cutscene(new String[]{"You made " + Crafter.craft(item, i).getName()}));
                    item = null;
                } else System.out.println("Not crafted");
            }
        }
    }

    /**
     * activateTeleport
     * Activates the teleport on this cell
     */
    public void activateTeleport () {
        Player.changeBoard(this.teleport, dir);
    }

    /**
     * cueCutscene
     * Feeds the cutscene into the Game class and sets it to null
     */
    public void cueCutscene () {
        Game.cueCutscene(cutscene);
        cutscene = null;
    }

    /**
     * destroyObstacle
     * Destroys obstacle on the tile, opens direction, consumes item
     */
    public void destroyObstacle (Item i, Position pos, Position board) {
        if (obstacle.destroy(i)) { // Opens direction if the obstacle gets destroyed
            if (dir == 'u') {
                openDirection(pos, board);
            } else if (dir == 'r') {
                openDirection(pos, board);
            } else if (dir == 'd') {
                openDirection(pos, board);
            } else if (dir == 'l') {
                openDirection(pos, board);
            }
            System.out.println(obstacle.getName() + " was destroyed using " + i.getName());
            Player.removeItem(i);
            openDir = ' '; // No more open dir
        } else {
            System.out.println("Item not consumed"); // Else it gives the player an error message
            Game.cueCutscene(new Cutscene(new String[]{"You can't really use that here."}));
        }
    }

    /** Opens the direction when an obstacle is destroyed so the player may pass*/
    public void openDirection (Position pos, Position board) {
        if (openDir == 'u') {
            this.collision[0] = false;
            MazeBoard.get(board).getCell(pos.getX(), pos.getY()-1).changeCollision('d', false, board, pos);
        } else if (openDir == 'r') {
            this.collision[1] = false;
            MazeBoard.get(board).getCell(pos.getX()+1, pos.getY()).changeCollision('l', false, board, pos);
        } else if (openDir == 'd') {
            this.collision[2] = false;
            MazeBoard.get(board).getCell(pos.getX(), pos.getY()+1).changeCollision('u', false, board, pos);
        } else if (openDir == 'l') {
            this.collision[3] = false;
            MazeBoard.get(board).getCell(pos.getX()-1, pos.getY()).changeCollision('r', false, board, pos);
        }
    }

    /** Picks up the item on a tile and places it into the inventory of the player*/
    public void pickupItem ()  {
        if (Player.addItem(item)) {
            Game.cueCutscene(new Cutscene(new String[]{"You got " + item.getName() + "."}));
            item = null;
        }
        else System.out.println("Inventory is full! Can't pickup...");
    }

    /**
     * drawCell
     * Draws the cell and anything that it contains
     * @param pen the GraphicsContext that it'll draw it in
     * @param scale how big the cell is to be drawn
     * @param position where the cell is
     * */
    public void drawCell (GraphicsContext pen, int scale, Position position) {
        if (hasItem()) { // Draws the item if there is one
            item.drawItem(pen);
        }
        if (hasMachine()) { // Draws the machine if there is one
            machine.draw(pen);
        }
        if (hasObstacle()) { // Draws the obstacle if there is one
            obstacle.drawObstacle(pen);
        }
        pen.setStroke(Color.BLACK);
        if (collision[0] && position.getY() == 0) { // Because of the order that the cells are drawn and the fact that collisions are mutual, not drawing certain ones allows the red strokes to show
            pen.strokeLine(0, 0, scale, 0);
        }
        if (collision[1]) {
            pen.strokeLine(scale, 0, scale, scale);
        }
        if (collision[2]) {
            pen.strokeLine(0, scale, scale, scale);
        }
        if (collision[3] && position.getX() == 0) {
            pen.strokeLine(0, 0, 0, scale);
        }
        if (hasItem() || hasMachine() || hasObstacle()) { // Repeated so that the items don't overlap too much with the lines which causes thinner lines
            if (collision[0]) {
                pen.strokeLine(0, 0, scale, 0);
            }
            if (collision[1]) {
                pen.strokeLine(scale, 0, scale, scale);
            }
            if (collision[2]) {
                pen.strokeLine(0, scale, scale, scale);
            }
            if (collision[3]) {
                pen.strokeLine(0, 0, 0, scale);
            }
            if (hasObstacle()) { // For the red strokes if there is an obstacle and an openDirection value
                pen.setStroke(Color.RED);
                if (openDir == 'u') pen.strokeLine(0, 0, scale, 0);
                else if (openDir == 'r') pen.strokeLine(scale, 0, scale, scale);
                else if (openDir == 'd') pen.strokeLine(0, scale, scale, scale);
                else if (openDir == 'l') pen.strokeLine(0, 0, 0, scale);
            }
        }
    }
}
