package com.oraen.oxygen.excelutil.component.workbook.creator;

import com.oraen.oxygen.excelutil.component.SauryConverter;
import com.oraen.oxygen.excelutil.component.WbCreator;
import com.oraen.oxygen.excelutil.config.SauryConfig;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

public class EntitiesWbCreator implements WbCreator {


    private SauryConverter dataConverter = SauryConfig.saury;

    private List<String> heads;

    private List<?> data;

    @Override
    public Workbook creator() {
        System.out.println(dataConverter == null);
        List<Map<String, Object>> mapData = dataConverter.convert(data);
        WbCreator finalCreator = new StandMapsWbCreator(heads, mapData);
        return finalCreator.creator();
    }

    public EntitiesWbCreator(List<String> heads, List<?> data){
        this.heads = heads;
        this.data = data;
    }

    public List<String> getHeads() {
        return heads;
    }

    public void setHeads(List<String> heads) {
        this.heads = heads;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
