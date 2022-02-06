package model;

import exception.CookBookException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CookBook implements Storage<Recipe> {
    private final Map<Integer, Recipe> recipes = new HashMap<>();
    private int count = 0;

    @Override
    public void add(Recipe recipe) {
        if (recipes.containsValue(recipe))
            throw new CookBookException("Recipe " + recipe.getDish().getName() + " already present into cook book");
        recipes.put(++count, recipe);
    }

    @Override
    public boolean delete(String recipeName) {
        Recipe findRecipe = find(recipeName);
        if (findRecipe == null)
            return false;
        recipes.remove(findRecipe);
        return true;
    }

    @Override
    public Recipe find(String recipeName) {
        List<Recipe> findRecipe = recipes.values().stream()
                .filter(recipe -> recipe.getDish().getName().equals(recipeName))
                .collect(Collectors.toList());
        if (findRecipe.isEmpty())
            return null;
        return findRecipe.get(0);
    }

    @Override
    public List<Recipe> findAll() {
        return new ArrayList<>(recipes.values());
    }

    @Override
    public List<Recipe> findByDifficulty(Difficulty difficulty) {
        return recipes.values().stream()
                .filter(recipe -> recipe.getDifficulty() == difficulty)
                .collect(Collectors.toList());
    }
}
