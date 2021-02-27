package com.oraen.oxygen.excelutil.exception;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.dataUtil.DataFormatUtil;

import java.sql.SQLException;
import java.util.Map;

public class CustomException extends Exception {

    private Map<String, Object> detail = new JSONObject();

    public CustomException(){
        super();
    }

    public CustomException(String message){
        super(message);
    }

    public Map<String, Object> getDetail() {
        return detail;
    }

    public Object getDetail(String name) {
        return detail.get(name);
    }

    public void setDetail(Map<String, Object> detail) {
        this.detail = detail;
    }

    public void addDetail(String name, Object value){
        detail.put(name, value);
    }

    public void removeDetail(String name){
        detail.remove(name);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("细节信息\n" + DataFormatUtil.visualization(detail));
    }
}
