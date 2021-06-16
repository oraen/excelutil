package com.oraen.oxygen.excelutil.component.workbook.node;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapsValuePusher extends ExplicitWbNode {

    private List<Map<String, Object>> data;
    private List<String> order;

    public MapsValuePusher(List<String> order, List<Map<String, Object>> data){
        this.data = data;
        this.order = order;
    }

    public MapsValuePusher(List<String> order){
        this.order = order;
    }

    public MapsValuePusher(){
    }


    @Override
    public void modify(Sheet sheet) {
        autoInit();
        MapValuePusher mapValuePusher = new MapValuePusher();
        mapValuePusher.point = this.point;
        mapValuePusher.setOrder(order);
        for(Map<String, Object> map : data){
            mapValuePusher.setData(map);
            mapValuePusher.modify(sheet);
            point.nextRow();
            point.resetLine();
        }

    }

    private void autoInit(){
        if(order == null){
            order = new ArrayList<>(16);
            for(Object o : data.get(0).keySet()){
                order.add(o.toString());
            }
        }
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public List<String> getHeads() {
        return order;
    }

    public void setHeads(List<String> order) {
        this.order = order;
    }
}
