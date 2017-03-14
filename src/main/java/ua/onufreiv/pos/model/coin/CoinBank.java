package ua.onufreiv.pos.model.coin;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class CoinBank {
    private int activeSum;

    public int getCurrentSum() {
        return activeSum;
    }

    public void insertMoney(Coin coin) {
        activeSum += coin.getValue();
    }

    public void resetCurrentSum() {
        activeSum = 0;
    }

    public Coin[] getAcceptedMoney() {
        return Coin.values();
    }
}
