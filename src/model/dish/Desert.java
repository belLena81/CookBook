package model.dish;

public class Desert extends Dish{

    Desert(String name) {
        super(name);
    }

    @Override
    public String serve() {
        return "Desert " + getName() + " serves after main dishes";
    }
}
