package model;

import exception.CookBookException;
import model.dish.Dish;

import java.io.*;
import java.util.*;

public class Recipe {
    private Dish dish;
    private final Set<Ingredient> ingredients;
    private List<String> description;
    private int time;
    private Difficulty difficulty;

    public Recipe(Dish dish, int time, Difficulty difficulty) {
        this.dish = dish;
        this.ingredients = new HashSet<>();
        this.description = new ArrayList<>();
        this.time = time;
        this.difficulty = difficulty;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public boolean addIngredient(Ingredient ingredient) {
        return ingredients.add(ingredient);
    }

    public boolean deleteIngredient(Ingredient ingredient) {
        return ingredients.remove(ingredient);
    }

    public List<String> getDescription() {
        return description;
    }

    public void addStepIntoDescription(String description) {
        this.description.add(description);
    }

    public void addDescription(String fileName) {
        File descriptionFile = new File(fileName);
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(descriptionFile)))) {
            while (scanner.hasNext()) {
                description.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new CookBookException("Cannot load description from file " + fileName);
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "dish=" + dish.getName() +
                ", ingredients=" + ingredients +
                ", description=" + description + '\'' +
                ", time=" + time +
                ", difficulty=" + difficulty +
                '}';
    }
}
