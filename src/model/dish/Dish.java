package model.dish;

public abstract class Dish {
    private String name;

    Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String serve();

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dish)
            return ((Dish) o).name.equals(name);
        else return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
