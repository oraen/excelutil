package com.oraen.oxygen.excelutil.exception;

public class CheckFailException extends CustomException {

    public CheckFailException(String cause){
        super(cause);
        this.addDetail("cause", cause);
    }

}
