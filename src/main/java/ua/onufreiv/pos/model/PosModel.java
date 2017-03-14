package ua.onufreiv.pos.model;

import ua.onufreiv.pos.model.coin.Coin;
import ua.onufreiv.pos.model.coin.CoinBank;
import ua.onufreiv.pos.model.product.Product;
import ua.onufreiv.pos.model.product.ProductCatalog;
import ua.onufreiv.pos.model.sale.Sale;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class PosModel {
    private static PosModel instance;

    private ProductCatalog productCatalog;
    private CoinBank coinBank;
    private Sale currentSale;

    private PosModel() {
        currentSale = new Sale();
        init();
    }

    private void init() {
        this.productCatalog = ProductCatalog.getInstance();
        this.coinBank = new CoinBank();
    }

    public static PosModel getInstance() {
        if (instance == null) {
            instance = new PosModel();
        }

        return instance;
    }

    public void insertMoney(Coin coin) {
        coinBank.insertMoney(coin);
    }

    public boolean chooseProduct(String productName, int quantity) {
        Product product = productCatalog.getByName(productName);
        if (product == null) {
            return false;
        }
        currentSale.addLineItem(product, quantity);
        return true;
    }

    public Payment buy() {
        if (currentSale == null || coinBank.getCurrentSum() == 0) {
            return null;
        }

        Payment payment = currentSale.makePayment(coinBank.getCurrentSum());
        coinBank.resetCurrentSum();
        currentSale = new Sale();
        return payment;
    }

    public int cancel() {
        int coinsToReturn = coinBank.getCurrentSum();
        coinBank.resetCurrentSum();
        currentSale = new Sale();
        return coinsToReturn;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public Sale getCurrentSale() {
        return currentSale;
    }

    public CoinBank getCoinBank() {
        return coinBank;
    }
}
