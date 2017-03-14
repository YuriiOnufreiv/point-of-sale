package ua.onufreiv.pos.model.sale;

import ua.onufreiv.pos.model.Payment;
import ua.onufreiv.pos.model.product.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Sale {
    private Date date;
    private List<SalesLineItem> itemList;

    public Sale() {
        date = new Date();
        itemList = new ArrayList<>();
    }

    public int getTotal() {
        int total = 0;
        for (SalesLineItem lineItem : itemList) {
            total += lineItem.getSubtotal();
        }
        return total;
    }

    public SalesLineItem addLineItem(Product product, int quantity) {
        SalesLineItem salesLineItem = new SalesLineItem(product, quantity);
        itemList.add(salesLineItem);
        return salesLineItem;
    }

    public Payment makePayment(int coinsInserted) {
        if (coinsInserted < getTotal()) {
            return null;
        }
        return new Payment(this, coinsInserted);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sale information:\n")
                .append("Date: ").append(date).append("\n")
                .append("Items:");

        if (itemList.size() == 0) {
            builder.append(" - ");
        } else {
            builder.append("\n");
            for (SalesLineItem item : itemList) {
                Product product = item.getProduct();
                builder.append(product.getDescription())
                        .append(", (")
                        .append(product.getPrice())
                        .append(" x ")
                        .append(item.getQuantity())
                        .append(") : ")
                        .append(item.getSubtotal());
            }
        }
        return builder.toString();
    }
}
