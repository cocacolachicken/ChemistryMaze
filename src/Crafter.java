import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

/** Stores recipes for the items to combine into
 * @author Tyler Gu
 * @version 1.3
 * @since 1.0
 */
public class Crafter {
    // Recipes are stored this way
    private static Map<Integer, Map<Integer, Item>> recipes = new HashMap<>();

    /**
     * addRecipe
     * Adds a recipe to the recipes Map (being ingredient1 + ingredient2 = result)
     * @param ingredient1 the ID of the ingredient one wishes to put
     * @param ingredient2 the ID of the ingredient one wishes to put
     * @param result the resulting item
     */
    private static void addRecipe (int ingredient1, int ingredient2, Item result) {
        if (recipes.get(ingredient1) == null) {
            recipes.put(ingredient1, new HashMap<>());
        }
        if (recipes.get(ingredient2) == null) {
            recipes.put(ingredient2, new HashMap<>());
        }
        recipes.get(ingredient1).put(ingredient2, result);
        recipes.get(ingredient2).put(ingredient1, result);
    }

    /**
     * craft
     * Returns an item in a recipe book according to the two ingredients
     * @param ingredient1 Ingredient
     * @param ingredient2 Ingredient
     * @return returns the item to be crafted
     * */
    public static Item craft (Item ingredient1, Item ingredient2) {
        return recipes.get(ingredient1.getID()).get(ingredient2.getID());
    }

    /** Initializes the recipes*/
    public static void initialize () {
        addRecipe(1, 2, ItemDirectory.getItem(3));
        addRecipe(0, 3, ItemDirectory.getItem(4));
        addRecipe(6, 7, ItemDirectory.getItem(8));
        addRecipe(9, 10, ItemDirectory.getItem(11));
        addRecipe(13, 14, ItemDirectory.getItem(15));
        addRecipe(17, 18, ItemDirectory.getItem(19));
    }
}
