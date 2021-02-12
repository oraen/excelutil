package com.oraen.oxygen.excelutil.exception;

public class AccessingEmptyException extends Exception {

    public AccessingEmptyException(String message){
        super(message);
    }

    public AccessingEmptyException(){
        super();
    }
}
