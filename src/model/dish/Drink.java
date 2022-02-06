package model.dish;

public class Drink extends Dish{
    private final int temperature;
    private final boolean alcohol;

    public Drink(String name, int temperature) {
        this(name, temperature, false);
    }

    public Drink(String name, int temperature, boolean alcohol) {
        super(name);
        this.temperature = temperature;
        this.alcohol = alcohol;
    }

    @Override
    public String serve() {
        StringBuilder serveRule = new StringBuilder("Drink " + getName());
        if (temperature > 50)
            serveRule.append(" sevres hot");
        else if (temperature > 0)
            serveRule.append("serves cool");
        else
            serveRule.append("serves frozen");
        if (alcohol)
            serveRule.append(" in wineglass");
        return serveRule.toString();

    }
}
