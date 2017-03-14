package ua.onufreiv.pos.controller;

import ua.onufreiv.pos.controller.commands.Command;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Controller {
    private static Controller instance;
    private ControllerHelper controllerHelper;

    private Controller() {
        controllerHelper = ControllerHelper.getInstance();
    }

    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public PosResponse processRequest(PosRequest posRequest) {
        Command command = controllerHelper.getCommand(posRequest.getCommand());

        PosResponse posResponse = command.execute(posRequest.getArguments());

        return posResponse;
    }
}
