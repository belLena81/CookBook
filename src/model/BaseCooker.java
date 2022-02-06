package model;

import java.util.List;

public class BaseCooker implements Cooker{
    private final Storage<Recipe> cookBook = new CookBook();

    public void addRecipe(Recipe recipe) {
        cookBook.add(recipe);
    }

    public boolean deleteRecipe(String name) {
        return cookBook.delete(name);
    }

    private Recipe findRecipe(String name) {
        return cookBook.find(name);
    }

    public void cookDinner(List<String> dishes) {
        dishes.forEach(dish -> new Thread(() -> System.out.println(cook(dish))));
    }

    @Override
    public String cook(String name) {
        Recipe find = findRecipe(name);
        StringBuilder cook = new StringBuilder();
        if (find != null) {
            cook.append("I cook " + find.getDish().getName() + " for " +
                    find.getTime() + " minutes\n");
            cook.append("Steps:");
            List<String> description = find.getDescription();
            for (int i = 0; i < description.size(); i++) {
                cook.append("\n"+ i + " " + description.get(i));
            }
        } else
            cook.append("Unknown recipe. Can't cook");
        return cook.toString();
    }

    @Override
    public String serve(String name) {
        Recipe find = findRecipe(name);
        if (find == null)
            return "Unknown recipe. Cannot serve";
        return find.getDish().serve();
    }

    @Override
    public String knowledge() {
        StringBuilder knowledge = new StringBuilder();
        cookBook.findAll().stream().forEach(recipe -> knowledge.append(recipe.getDish().getName() + "\n"));
        return knowledge.toString();
    }
}
