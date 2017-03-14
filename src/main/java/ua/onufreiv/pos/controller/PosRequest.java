package ua.onufreiv.pos.controller;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class PosRequest {
    private String command;
    private String[] arguments;

    private PosRequest(String command, String[] arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getCommand() {
        return command;
    }

    public static PosRequest parse(String input) {
        String formattedInput = input.trim().replaceAll(" +", " ").toLowerCase();
        String command = formattedInput;
        String[] arguments = new String[0];

        int spaceIndex = formattedInput.indexOf(" ");
        if(spaceIndex > 0) {
            command = formattedInput.substring(0, spaceIndex);
            arguments = formattedInput.substring(spaceIndex + 1).split(" ");
        }

        return new PosRequest(command, arguments);
    }
}
