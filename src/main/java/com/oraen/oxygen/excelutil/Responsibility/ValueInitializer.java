package com.oraen.oxygen.excelutil.Responsibility;

import com.oraen.oxygen.excelutil.annotation.SheetField;
import com.oraen.oxygen.excelutil.exception.BreakNecessityException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public final class ValueInitializer implements WorkNode<String> {

    private static ValueInitializer valueInitializer;

    public static ValueInitializer getInstance(){
        if(valueInitializer == null){
            synchronized (UniqueChecker.class){
                if(valueInitializer == null){
                    valueInitializer = new ValueInitializer();
                }
            }
        }

        return valueInitializer;
    }


    private ValueInitializer(){}

    public String execute(String target, Object... params) throws BreakNecessityException {

        if(StringUtils.isBlank(target)){
            if(params[0] instanceof Field){
                Field field = (Field)params[0];
                SheetField sf = field.getAnnotation(SheetField.class);

                if(sf != null){
                    if(sf.necessity()){
                        throw new BreakNecessityException(field);
                    }else{
                        target = sf.lack();
                    }
                }


            }

        }


        return target;

    }
}
