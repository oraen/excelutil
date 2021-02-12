package com.oraen.oxygen.excelutil.exception;

public class BreakUniqueException extends  CustomException{

    public BreakUniqueException(){
        super("不允许重复的字段存在重复的数据");
    }

}
