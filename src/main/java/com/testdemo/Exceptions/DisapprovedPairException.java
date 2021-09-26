package com.testdemo.Exceptions;

public class DisapprovedPairException extends RuntimeException {

    private static final String message = "Not approved the pair.";

    public DisapprovedPairException() {
        super(message);
    }
}
