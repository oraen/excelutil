package com.oraen.oxygen.excelutil.exception;

import java.lang.reflect.Field;

public class BreakNormException extends CustomException {

    public BreakNormException(Field field, String value, String regexp){
        super("字段 " + field.toGenericString() + " 的值" + value + "不符合规范 " + regexp);
        this.addDetail("value", value);
        this.addDetail("norm", regexp);
        this.addDetail("field", field);
    }
}
