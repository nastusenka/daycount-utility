package com.nastusenka.weekdaycounter.exceptions;

public class InvalidDateException extends Exception {
    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super("Date doesn't match pattern YYYY-MM-DD (" + message + ")");
    }
}
