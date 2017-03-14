package ua.onufreiv.pos.controller.commands;

import ua.onufreiv.pos.controller.PosResponse;

/**
 * @author Yurii Onufreiv
 * @version 1.0
 */
public interface Command {
    PosResponse execute(String[] args);
}
