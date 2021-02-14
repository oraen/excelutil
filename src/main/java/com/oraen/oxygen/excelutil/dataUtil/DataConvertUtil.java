package com.oraen.oxygen.excelutil.dataUtil;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.Responsibility.ValueInitializer;
import com.oraen.oxygen.excelutil.annotation.SheetField;
import com.oraen.oxygen.excelutil.exception.BreakNecessityException;
import com.oraen.oxygen.excelutil.exception.UnavailableTypeException;
import com.oraen.oxygen.excelutil.exception.UnspecificException;
import java.lang.reflect.Field;
import com.oraen.oxygen.excelutil.exception.UnexpectedException;
import java.util.LinkedList;
import java.util.List;

public class DataConvertUtil {


    public static<T> List<T> transform(List<JSONObject> list, Class<T> clazz) throws UnavailableTypeException, UnexpectedException, UnspecificException, BreakNecessityException {
        List<T> re = new LinkedList<T>();

        for(JSONObject map : list){
            T t = transform(map, clazz);
            re.add(t);
        }

        return re;
    }


    public static<T> T transform(JSONObject map, Class<T> clazz) throws UnavailableTypeException, UnspecificException, UnexpectedException, BreakNecessityException {

        T t = CommonUtil.create(clazz);
        Field[]  entityFields = clazz.getDeclaredFields();

        try{
            for(Field entityField : entityFields){
                SheetField sf = entityField.getAnnotation(SheetField.class);
                if(sf != null){
                    String value = (String)map.get(sf.value());
                    value = ValueInitializer.getInstance().execute(value, entityField);
                    entityField.setAccessible(true);
                    Class<?> type =  entityField.getType();
                    if(type == String.class){
                        entityField.set(t, value);
                    }else if(type == Integer.class || type == int.class){
                        entityField.set(t, Integer.parseInt(value));
                    }else if(type == Float.class || type == float.class){
                        entityField.set(t, Float.parseFloat(value));
                    }else if(type == Double.class || type == double.class){
                        entityField.set(t, Double.parseDouble(value));
                    }else if(type == Long.class || type == long.class){
                        entityField.set(t, Long.parseLong(value));
                    }else{
                        throw new UnavailableTypeException(entityField.getType());
                    }
                }
            }

            return t;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            throw new UnexpectedException("初始化对象失败");
        }

    }


    public static List<JSONObject> transform(List<?> list) throws UnexpectedException {

        List<JSONObject> re = new LinkedList<JSONObject>();

        for(Object t : list){
            JSONObject map = transform(t);
            re.add(map);
        }

        return re;
    }


    public static JSONObject transform(Object object) throws  UnexpectedException {

        try{
            Class<?> clazz = object.getClass();
            JSONObject re = new JSONObject();

            Field[] entityAllFields = clazz.getDeclaredFields();

            for(Field entityField : entityAllFields){
                SheetField sf = entityField.getAnnotation(SheetField.class);
                if(sf != null){
                    entityField.setAccessible(true);
                    String value = String.valueOf(entityField.get(object));
                    if("null".equals(value) || value == null){
                        value = "";
                    }
                    re.put(sf.value(), value);
                }
            }

            return re;
        }catch (IllegalAccessException e){
            e.printStackTrace();
            throw new UnexpectedException("获取对象地值时出错");
        }


    }
}
