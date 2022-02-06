package model.dish;

public class MainDish extends Dish{
    private int temperature;

    MainDish(String name, int temperature) {
        super(name);
        this.temperature = temperature;
    }

    @Override
    public String  serve() {
        StringBuilder serveRule = new StringBuilder("Dish " + getName());
        if (temperature > 50)
          serveRule.append(" sevres hot");
        else if (temperature > 0)
            serveRule.append("serves cool");
        else
            serveRule.append("serves frozen");
        return serveRule.toString();
    }
}
