package com.oraen.oxygen.excelutil.exception;

import com.oraen.oxygen.excelutil.annotation.SheetField;

import java.lang.reflect.Field;

public class BreakNecessityException extends CustomException {

    public BreakNecessityException(Field field){
        super("不可将空值赋给字段： " + field.getName() );
        this.addDetail("FieldName", field.getName());
        this.addDetail("Field", field);
        this.addDetail("EntityField", field.getAnnotation(SheetField.class).value());
    }
}
