package com.oraen.oxygen.excelutil.component.saury;

import com.oraen.oxygen.common.design.workstation.FieldNode;
import com.oraen.oxygen.common.structure.map.Shelf;
import com.oraen.oxygen.common.util.ReflectUtil;
import com.oraen.oxygen.excelutil.SheetField;
import com.oraen.oxygen.excelutil.component.SauryConverter;

import java.lang.reflect.Field;
import java.util.Map;

public class Saury extends SauryConverter {


    @Override
    public Map<String, Object> from(Object source) {
        Class<?> clazz = source.getClass();
        Map<String, Object> re = new Shelf<>();
        Map<String, Field> fieldMap = ReflectUtil.getAllFields(source);

        for(Field entityField : fieldMap.values()){
            SheetField sf = entityField.getAnnotation(SheetField.class);
            if(sf != null){
                Object value =  ReflectUtil.getFieldValue(source, entityField);
                re.put(sf.value(), value);
            }
        }

        return re;
    }

}
