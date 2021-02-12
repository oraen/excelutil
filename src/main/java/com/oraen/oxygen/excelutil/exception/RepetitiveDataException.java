package com.oraen.oxygen.excelutil.exception;

import java.util.HashSet;
import java.util.Set;

public class RepetitiveDataException extends CustomException {

    public RepetitiveDataException(){
        this(new HashSet<Object>());

    }

    public RepetitiveDataException(Set<? extends Object> set){
        super("出现重复数据");
        this.addDetail("repetition", set);
    }

    public void put(Object obj){
        Set<Object> set = ((Set<Object>)(this.getDetail("repetition")));
        set.add(obj);
    }

    public RepetitiveDataException(Object... objs){
        this();
        for(Object o : objs){
            this.put(o);
        }
    }
}
