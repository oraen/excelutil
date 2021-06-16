package com.oraen.oxygen.excelutil.component.workbook.node;

import com.oraen.oxygen.excelutil.BaseUtil;
import com.oraen.oxygen.excelutil.component.Point;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

public class MapValuePusher extends ExplicitWbNode {
    private Map<?, ?> data;
    private List<String> order;

    public MapValuePusher(Map<?, ?> data){
        this.data = data;
    }

    public MapValuePusher(){
        this(new HashMap<>(0));
    }


    @Override
    public void modify(Sheet sheet) {
        autoInit();
        for(String str : order){
            BaseUtil.set(sheet, point.getRow(), point.getLine(), data.get(str));
            point.nextLine();;
        }
    }

    private void autoInit(){
        if(order == null){
            order = new ArrayList<>(16);
            for(Object o : data.keySet()){
                order.add(o.toString());
            }
        }
    }

    public Map<?, ?> getData() {
        return data;
    }

    public void setData(Map<?, ?> data) {
        this.data = data;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

}
