package com.oraen.oxygen.excelutil.exception;

import java.lang.reflect.Type;

public class UnavailableTypeException extends CustomException {

    public UnavailableTypeException(Class<?> type){
        super("不支持的数据类型 "+ type.getName());
        this.addDetail("unavailability", type.getName());
    }

}
