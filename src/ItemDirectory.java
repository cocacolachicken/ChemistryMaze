import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/** A place to keep track and organize items
 * @author Tyler
 * @version 1.3 Changed src/images/... to Resources/images/...
 * @since 1.0
 */
public class ItemDirectory {
    // Holds the Items
    private static ArrayList<Item> itemList = new ArrayList<>();

    /** Adds an item to the item list
     * @param n name of item
     * @param d description of item
     * @param image image to be displayed
     * */
    private static void addItem (String n, String d, String image) throws FileNotFoundException {
        itemList.add(new Item(n, itemList.size(), d, new Image(new FileInputStream(image))));

    }

    /** "Initializes" the values for the items*/
    public static void initialize () throws FileNotFoundException {
        addItem("Test tube", "A clear glass tube", "Resources/images/testtube.jpeg");
        addItem("Vinegar", "Or 5% acetic acid (CH3COOH)", "Resources/images/vinegar.jpeg");
        addItem("Baking soda", "Or powdered sodium bicarbonate (NaHCO3)", "Resources/images/baking-soda.jpeg");
        addItem("Carbon dioxide", "(CO2) Collect this in a tube!", "Resources/images/smoke.png");
        addItem("Carbon dioxide (in tube)", "(CO2) Now you can use this", "Resources/images/testtube.jpeg");
        addItem("Cola", "Refreshing!", "Resources/images/coke.png");
        addItem("Empty lighter", "It can't light", "Resources/images/lighter.jpeg"); // index: 6
        addItem("Butane", "(C4H10) Lighter fluid", "Resources/images/butane.jpeg"); // index: 7
        addItem("Lighter", "It can light", "Resources/images/lighter.jpeg"); // index: 8
        addItem("Ammonia", "(NH4) Don't mix with bleach!", "Resources/images/ammonia.jpeg"); // index: 9
        addItem("Nitric acid", "(HNO3) Don't touch!", "Resources/images/nitricacid.jpeg"); // index: 10
        addItem("Fertilizer", "(NH4NO3) Or ammonium nitrate", "Resources/images/ammoniumnitrate.jpeg"); // index: 11
        addItem("Sodium hydroxide", "(NaOH) Also known as lye", "Resources/images/naoh.jpeg"); // index: 12
        addItem("Pure zinc", "(Zn) You can eat this!", "Resources/images/zinc.jpeg"); // index: 13
        addItem("Scraper tool", "It's very flimsy", "Resources/images/scraper.jpeg"); // index: 14
        addItem("Zinc oxide", "(ZnO) From scraping the zinc!", "Resources/images/zincoxide.jpeg"); // index: 15
        addItem("Mineral sunscreen", "20% Zinc Oxide for SPF50", "Resources/images/suncream.jpeg"); // index: 16
        addItem("Water", "(H2O) Stay hydrated!", "Resources/images/distilledwater.jpeg"); // index: 17
        addItem("Sodium", "(Na) Don't eat this!", "Resources/images/sodium.jpeg"); // 18
        addItem("Explosion", "How did you pick this up?", "Resources/images/explosion.png"); // 19
        addItem("50 cent coin", "This is a relic of the past", "Resources/images/50centcoin.jpeg"); // 20
    }

    /** Gets an item according to the ID*/
    public static Item getItem (int itemID) {
        return itemList.get(itemID);
    }
}
