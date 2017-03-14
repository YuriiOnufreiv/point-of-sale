package ua.onufreiv.pos.model.sale;

import ua.onufreiv.pos.model.product.Product;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class SalesLineItem {
    private Product product;
    private int quantity;

    public SalesLineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubtotal() {
        return product.getPrice() * quantity;
    }
}
