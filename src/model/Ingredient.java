package model;

public class Ingredient {
    private String name;
    private Category category;
    private String measure;
    private float quantity;

    public Ingredient(String name, Category category, String measure, float quantity) {
        this.name = name;
        this.category = category;
        this.measure = measure;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", measure='" + measure + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
