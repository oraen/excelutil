package com.oraen.oxygen.excelutil.exception;

//RuntimeException异常以及抛出的其子类异常是不需要try/catch捕获的异常
public class UnexpectedException extends RuntimeException {
    public UnexpectedException(String message){
        super(message);
    }
}
