package ua.onufreiv.pos;

import ua.onufreiv.pos.view.ConsolePosView;
import ua.onufreiv.pos.view.PosView;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        PosView posView = new ConsolePosView();
        posView.start();
    }
}
