package com.oraen.oxygen.excelutil.component.workbook.creator;

import com.oraen.oxygen.excelutil.component.WbCreator;
import com.oraen.oxygen.excelutil.component.WbNode;
import com.oraen.oxygen.excelutil.component.workbook.node.ValuesInjector;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Collection;
import java.util.List;

public class StandTemplateCreator implements WbCreator {

    private WbNode headInjector;

    public StandTemplateCreator(List<String> head){
        this.headInjector = new ValuesInjector(head);
    }

    @Override
    public Workbook creator() {
        Workbook wb = new XSSFWorkbook();
        wb.createSheet("sheet1");
        headInjector.execute(wb);
        return wb;
    }
}
