package com.oraen.oxygen.excelutil.component;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 把map对象转化为sheet实体类
 */
public abstract class CitrusConverter {

    public<T> List<T> create(List<Map<String, Object>> source, Class<T> clazz){

        List<T> re = new ArrayList<>();
        for(Map<String, Object> map : source){
            re.add(create(map, clazz));
        }
        return re;
    }


    public abstract<T> T create(Map<String, Object> map, Class<T> clazz);

}
