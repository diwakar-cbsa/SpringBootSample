package com.shn.exceptions;

public class ShnExceptions extends Exception {

    private String errorMsg;

    public ShnExceptions() {
        super();
    }

    public ShnExceptions(String errorMsg) {
        super(errorMsg);
    }
}
