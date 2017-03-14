package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;
import ua.onufreiv.pos.model.coin.Coin;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class InsertCoinCommand implements Command {
    private PosModel posModel;

    public InsertCoinCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        int value = Integer.parseInt(args[0]);
        Coin coin = Coin.toCoin(value);

        if (coin == null) {
            return new PosResponse("Coin wasn't accepted");
        }

        posModel.insertMoney(coin);

        StringBuilder builder = new StringBuilder()
                .append("Coin ")
                .append(coin.name())
                .append(" accepted. Total - ")
                .append(posModel.getCoinBank().getCurrentSum());

        return new PosResponse(builder.toString());
    }
}
