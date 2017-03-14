package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.Payment;
import ua.onufreiv.pos.model.PosModel;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class BuyCommand implements Command {
    private PosModel posModel;

    public BuyCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        Payment payment = posModel.buy();

        if(payment == null) {
            return new PosResponse("Can't proceed. Product is not selected or inserted money isn't enough");
        }

        return new PosResponse("SUCCESS\n" + payment);
    }
}
