package com.testdemo.Exceptions;

public class TestedAlreadyPairException extends RuntimeException {

    private static final String message = "The pair is already tested and is not valid anymore!";

    public TestedAlreadyPairException() {
        super(message);
    }
}
