package ua.onufreiv.pos.model;

import ua.onufreiv.pos.model.sale.Sale;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Payment {
    private Sale sale;
    private int coinsInserted;
    private int change;

    public Payment(Sale sale, int coinsInserted) {
        this.sale = sale;
        this.coinsInserted = coinsInserted;

        change = coinsInserted - sale.getTotal();
    }

    public Sale getSale() {
        return sale;
    }

    public int getCoinsInserted() {
        return coinsInserted;
    }

    public int getChange() {
        return change;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Payment Info")
                .append("\n")
                .append(sale)
                .append("Total: ").append(getSale().getTotal()).append("\n")
                .append("Inserted Coins: ").append(coinsInserted).append("\n")
                .append("Change : ").append(change);
        return builder.toString();
    }
}
