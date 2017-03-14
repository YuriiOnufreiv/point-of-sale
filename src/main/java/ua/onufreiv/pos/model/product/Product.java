package ua.onufreiv.pos.model.product;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Product {
    private String description;
    private int price;

    public Product(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return price + ", " + description;
    }
}
