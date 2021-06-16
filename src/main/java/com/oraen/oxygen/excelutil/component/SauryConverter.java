package com.oraen.oxygen.excelutil.component;

import com.oraen.oxygen.common.design.converter.BatchConverter;
import com.oraen.oxygen.common.structure.map.Shelf;

import java.util.Map;

/**
 * 把sheet实体类转化为map对象
 */
public abstract class SauryConverter implements BatchConverter<Object, Map<String, Object>> {

    @Override
    public abstract Map<String, Object> from(Object source);
}
