package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;
import ua.onufreiv.pos.model.PosModel;

/**
 * Created by Yurii_Onufreiv on 14-Mar-17.
 */
public class HelpCommand implements Command {
    private PosModel posModel;

    public HelpCommand() {
        posModel = PosModel.getInstance();
    }

    @Override
    public PosResponse execute(String[] args) {
        StringBuilder builder = new StringBuilder("List of available commands:\n");
        builder.append("-- [catalog] ").append(" shows catalog list").append("\n")
                .append("-- [coin amount] ").append(" inserts coin to bank").append("\n")
                .append("-- [catalog name amount] ").append(" adds selected catalog to sale").append("\n")
                .append("-- [buy] ").append(" performs payment").append("\n")
                .append("-- [bank] ").append(" shows bank status").append("\n")
                .append("-- [sale] ").append(" shows sale info").append("\n")
                .append("-- [cancel] ").append(" cancels the sale");
        return new PosResponse(builder.toString());
    }
}
