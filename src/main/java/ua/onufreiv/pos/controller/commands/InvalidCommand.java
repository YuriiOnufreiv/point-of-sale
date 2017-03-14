package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;

/**
 * Created by Yurii_Onufreiv on 14-Mar-17.
 */
public class InvalidCommand implements Command {
    public InvalidCommand() {
    }

    @Override
    public PosResponse execute(String[] args) {
        return new PosResponse("Invalid command");
    }
}
