package com.nnamdi.library.exceptions;

public class DuplicateException extends RuntimeException {
    private String message;
    public DuplicateException(String message){
        super(message);
        this.message = message;
    }
    public DuplicateException() {

    }


}
