package com.oraen.oxygen.excelutil.Responsibility;

import com.oraen.oxygen.excelutil.annotation.SheetField;
import com.oraen.oxygen.excelutil.exception.BreakNormException;
import com.oraen.oxygen.excelutil.exception.UnexpectedException;

import java.lang.reflect.Field;
import java.util.Collection;

public final class NormVerifier implements WorkNode<Collection<?>> {

    private static NormVerifier normVerifier = null;

    public static NormVerifier getInstance(){
        if(normVerifier == null){
            synchronized (NormVerifier.class){
                if(normVerifier == null){
                    normVerifier = new NormVerifier();
                }
            }
        }

        return normVerifier;
    }


    private NormVerifier(){}


    public Collection<?> execute(Collection<?> target, Object... params) throws BreakNormException, UnexpectedException {

        try{
            for(Object o : target){
                Field[] fields = o.getClass().getDeclaredFields();
                for(Field field : fields){
                    SheetField sf =field.getAnnotation(SheetField.class);
                    if(sf != null){
                        String regexp = sf.norm();
                        if(".*".equals(regexp)){
                            break;
                        }
                        Object value = field.get(o);
                        field.setAccessible(true);
                        if(value instanceof String){
                            String sValue = (String)value;
                            if(!sValue.matches(regexp)){
                                throw new BreakNormException(field, sValue, regexp);
                            }
                        }
                    }
                }
            }
            return target;
        }catch(IllegalAccessException e){
            e.printStackTrace();
            throw new UnexpectedException("获取字段值失败");
        }

    }
}
