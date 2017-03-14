package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class SelectProductCommand implements Command {
    private PosModel posModel;

    public SelectProductCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        String productName = args[0];
        int quantity = Integer.parseInt(args[1]);

        if(!posModel.chooseProduct(productName, quantity)) {
            return new PosResponse("Invalid catalog selection");
        }

        StringBuilder builder = new StringBuilder();
        builder.append("New catalog, ")
                .append(productName)
                .append(" (x").append(quantity).append("),")
                .append(" was added to your sale list");

        return new PosResponse(builder.toString());
    }
}
