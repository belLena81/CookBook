import exception.CookBookException;
import model.*;
import model.dish.Dish;
import model.dish.Drink;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final BaseCooker cooker = new BaseCooker();
        Dish dish = new Drink("tea", 90);
        Category category = new Category("beverage");
        Category subCategory = new Category("hot beverage", category);

        Recipe recipe = new Recipe(dish, 5, Difficulty.EASY);
        recipe.addIngredient(new Ingredient("tea", subCategory, "tea spoon", 1));
        recipe.addIngredient(new Ingredient("water", category, "ml", 200));
        recipe.addStepIntoDescription("Put tea into cup");
        recipe.addStepIntoDescription("Add hot water");
        recipe.addStepIntoDescription("Wait for 5 minute");
        recipe.addStepIntoDescription("Drink with lemon, sugar or honey");
        try {
            cooker.addRecipe(recipe);
        } catch (CookBookException e) {
            System.out.println("Cannot  add recipe " + recipe);
            System.out.println(e.getMessage());
        }
        System.out.println(cooker.knowledge());

        dish = new Drink("coffee", 100);

        recipe = new Recipe(dish, 5, Difficulty.EASY);
        recipe.addIngredient(new Ingredient("coffee", subCategory, "tea spoon", 1));
        recipe.addIngredient(new Ingredient("water", category, "ml", 100));
        try {
            recipe.addDescription("src/resources/coffeeRecipe.txt");
            cooker.addRecipe(recipe);
        } catch (CookBookException e) {
            System.out.println("Cannot  add recipe " + recipe);
            System.out.println(e.getMessage());
        }

        System.out.println(cooker.knowledge());

        System.out.println(cooker.cook("tea"));
        System.out.println(cooker.serve("coffee"));

        cooker.cookDinner(Arrays.asList("tea", "coffee"));

        if (cooker.deleteRecipe("coffee"))
            System.out.println("Cooker can't cook coffee for now");
        cooker.cook("coffee");

        System.out.println(cooker.knowledge());
    }
}
