package ua.onufreiv.pos.model.coin;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public enum Coin {
    ONE(1), FIVE(5), TEN(10), TWENTY_FIVE(25), FIFTY(50);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Coin toCoin(int value) {
        for(Coin coin : values()) {
            if(coin.getValue() == value) {
                return coin;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
