package com.oraen.oxygen.excelutil.component.citrus;

import com.oraen.oxygen.common.util.CommonUtil;
import com.oraen.oxygen.common.util.ReflectUtil;
import com.oraen.oxygen.excelutil.SheetField;
import com.oraen.oxygen.excelutil.component.CitrusConverter;

import java.lang.reflect.Field;
import java.util.Map;

public class Citrus extends CitrusConverter {
    @Override
    public <T> T create(Map<String, Object> map, Class<T> clazz) {
        T t = CommonUtil.create(clazz);
        Map<String, Field> fieldMap = ReflectUtil.getAllFields(clazz);
        for(Field entityField : fieldMap.values()){
            SheetField sf = entityField.getAnnotation(SheetField.class);
            if(sf != null){
                Object realValue = map.get(sf.value());
                if(realValue == null){
                    continue;
                }
                String value = realValue.toString();
                ReflectUtil.setFieldAuto(t, entityField, value);
            }
        }
        return t;
    }
}
