package com.company;

/**
 * Created by Mayank on 8/21/16.
 */
public class CalculatorException extends Exception {
    private String message;

    public CalculatorException(String message) {
        this.message = message;
    }

    @Override public void printStackTrace() {
        System.out.println(message);
    }
}
