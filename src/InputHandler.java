/** where all inputs are handled
 * @author Tyler
 * @version 1.3
 * @since 1.0
 */

public class InputHandler {
    /** Handles keyboard inputs*/
    public static void handleInput (Keyboard key, int currentMenu) {
        // WASD – turns into ULDR (Up Left Down Right) instead because i find it easier to work with.
        // Also directional inputs are clockwise most of the time
        if (currentMenu == 0) {
            if (key.getKey() == 'w') {
                Player.movePlayer('u');
            }
            if (key.getKey() == 'd') {
                Player.movePlayer('r');
            }
            if (key.getKey() == 'a') {
                Player.movePlayer('l');
            }
            if (key.getKey() == 's') {
                Player.movePlayer('d');
            }
            // Makes it so that ummmm something happens!
            try {
                if (key.getKey() >= '1' || key.getKey() <= '9') {
                    Player.useItem(key.getKey());
                }
            } catch (Exception ignored) {

            }
        }
    }

    /** Handles mouse inputs*/
    public static void handleInput (double mouseX, double mouseY, int currentMenu) {
        if (currentMenu == 1) { // If in a cutscene, advance it
            Game.getCurrentCutscene().advanceCutscene();
        } else if (currentMenu == 2) { // "Click to start"
            try {
                Game.startGame();
            } catch (Exception ignored) {

            }
        } else if (currentMenu == 0) { // if it's in range of the inventory bar thing
            if (mouseY > 500 && mouseY < 590) {
                if (mouseX > 100 && mouseX < 180) {
                    Game.cueCutscene(new Cutscene(new String[]{Player.getItem(0).getDescription()}));
                } else if (mouseX > 180 && mouseX < 260) {
                    Game.cueCutscene(new Cutscene(new String[]{Player.getItem(1).getDescription()}));
                } else if (mouseX > 260 && mouseX < 340) {
                    Game.cueCutscene(new Cutscene(new String[]{Player.getItem(2).getDescription()}));
                } else if (mouseX > 340 && mouseX < 420) {
                    Game.cueCutscene(new Cutscene(new String[]{Player.getItem(3).getDescription()}));
                } else if (mouseX > 420 && mouseX < 500) {
                    Game.cueCutscene(new Cutscene(new String[]{Player.getItem(4).getDescription()}));
                }
            }
        }
    }
}
