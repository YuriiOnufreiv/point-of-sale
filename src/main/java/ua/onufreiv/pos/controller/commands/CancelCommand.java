package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class CancelCommand implements Command {
    private PosModel posModel;

    public CancelCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        int change = posModel.cancel();

        if(change == 0) {
            return new PosResponse("No money was inserted. There is no change");
        }

        return new PosResponse("Take your money, please: " + change);
    }
}
