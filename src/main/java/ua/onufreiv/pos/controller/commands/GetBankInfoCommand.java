package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;
import ua.onufreiv.pos.model.coin.CoinBank;

import java.util.Arrays;

/**
 * Created by Yurii_Onufreiv on 14-Mar-17.
 */
public class GetBankInfoCommand implements Command {
    private PosModel posModel;

    public GetBankInfoCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        CoinBank moneyBank = posModel.getCoinBank();
        StringBuilder builder = new StringBuilder();
        builder.append("Accepted money : ")
                .append(Arrays.toString(moneyBank.getAcceptedMoney()))
                .append("\n")
                .append("Inserted total : ")
                .append(moneyBank.getCurrentSum());
        return new PosResponse(builder.toString());
    }
}
