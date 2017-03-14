package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;
import ua.onufreiv.pos.model.sale.Sale;

/**
 * Created by Yurii_Onufreiv on 14-Mar-17.
 */
public class GetSaleInfoCommand implements Command {
    private PosModel posModel;

    public GetSaleInfoCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        Sale currentSale = posModel.getCurrentSale();
        return new PosResponse(currentSale.toString());
    }
}
