package com.oraen.oxygen.excelutil.component.workbook.creator;


import com.oraen.oxygen.excelutil.component.WbCreator;
import com.oraen.oxygen.excelutil.component.workbook.node.MapsValuePusher;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

public class StandMapsWbCreator implements WbCreator {
    private List<String> heads;

    private List<Map<String, Object>> data;

    private WbCreator templateCreator;

    private MapsValuePusher dataInjector;

    @Override
    public Workbook creator() {
        Workbook wb = templateCreator.creator();
        dataInjector.getPoint().setRow(1);
        dataInjector.execute(wb);
        return wb;
    }


    public StandMapsWbCreator(List<String> heads, List<Map<String, Object>> data){
        this.data = data;
        this.heads = heads;
        this.templateCreator = new StandTemplateCreator(heads);
        this.dataInjector = new MapsValuePusher(heads, data);
    }

    public List<String> getHeads() {
        return heads;
    }

    public void setHeads(List<String> heads) {
        this.heads = heads;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public WbCreator getTemplateCreator() {
        return templateCreator;
    }

    public void setTemplateCreator(WbCreator templateCreator) {
        this.templateCreator = templateCreator;
    }
}
