package ua.onufreiv.pos.view;

import ua.onufreiv.pos.controller.Controller;
import ua.onufreiv.pos.controller.PosRequest;
import ua.onufreiv.pos.controller.PosResponse;

import java.util.Scanner;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class ConsolePosView implements PosView {
    private Controller controller;

    public ConsolePosView() {
        controller = Controller.getInstance();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Beverage Paradise!!!");
        System.out.println("Hint: type 'help' to see list fo all commands");

        while (true) {
            System.out.print("\n--> ");

            String input = scanner.nextLine();
            PosRequest posRequest = PosRequest.parse(input);
            PosResponse posResponse = controller.processRequest(posRequest);
            System.out.println(posResponse.getMessage());
        }
    }
}
