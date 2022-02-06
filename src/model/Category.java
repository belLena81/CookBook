package model;

public class Category {
    private String name;
    private Category subCategory;

    public Category(String name) {
        this(name, null);
    }

    public Category(String name, Category sub) {
        this.name = name;
        this.subCategory = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }
}
