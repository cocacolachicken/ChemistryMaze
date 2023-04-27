/** Stores position value as "x, y" (more like column, row)
 * @author Tyler Gu
 * @version 1.3
 * @since 1.0
 */
public class Position {
    private int x;
    private int y;

    // Constructs using x and y
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Changes the position according to the direction provided
     * @param direction the direction to travel
     * @param bound the limits of travl
     * */
    public void move (char direction, int bound) {
        if (direction == 'u' && Player.getPosition().getY() != 0) {
            this.y --;
        } else if (direction == 'd' && Player.getPosition().getY() != bound) {
            this.y ++;
        } else if (direction == 'r' && Player.getPosition().getX() != bound) {
            this.x ++;
        } else if (direction == 'l' && Player.getPosition().getX() != 0) {
            this.x --;
        }
    }

    // Getters
    public int getX () {
        return x;
    }
    public int getY () {
        return y;
    }
}
