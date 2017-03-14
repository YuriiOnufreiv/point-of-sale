package ua.onufreiv.pos.controller;

/**
 * Created by Yurii_Onufreiv on 14-Mar-17.
 */
public class PosResponse {
    private String message;

    public PosResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
