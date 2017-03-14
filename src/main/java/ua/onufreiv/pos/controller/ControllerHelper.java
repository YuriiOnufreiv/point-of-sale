package ua.onufreiv.pos.controller;

import ua.onufreiv.pos.controller.commands.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class ControllerHelper {
    private static ControllerHelper helperInstance = null;

    /**
     * Map that contains command name as a key, and command object as a value
     */
    private Map<String, Command> commands;

    /**
     * Initializes the {@code commands} map
     */
    private ControllerHelper() {
        commands = new HashMap<>();

        // common commands
        commands.put("coin", new InsertCoinCommand());
        commands.put("catalog", new SelectProductCommand());
        commands.put("cancel", new CancelCommand());
        commands.put("buy", new BuyCommand());
        commands.put("catalog", new DescribeProductCatalogCommand());
        commands.put("help", new HelpCommand());
        commands.put("sale", new GetSaleInfoCommand());
        commands.put("bank", new GetBankInfoCommand());
    }

    public static synchronized ControllerHelper getInstance() {
        if (helperInstance == null) {
            helperInstance = new ControllerHelper();
        }
        return helperInstance;
    }

    public Command getCommand(String input) {
        Command command = commands.get(input);

        if (command == null) {
            command = new InvalidCommand();
        }

        return command;
    }
}
