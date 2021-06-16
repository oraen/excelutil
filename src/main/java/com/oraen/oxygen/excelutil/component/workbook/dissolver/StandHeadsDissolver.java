package com.oraen.oxygen.excelutil.component.workbook.dissolver;

import com.oraen.oxygen.excelutil.BaseUtil;
import com.oraen.oxygen.excelutil.ExcelUtil;
import com.oraen.oxygen.excelutil.component.WbDissolver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class StandHeadsDissolver implements WbDissolver<List<String>> {
    @Override
    public List<String> getData(Sheet sheet) {
        Row row = sheet.getRow(0);
        List<String> re = new ArrayList<>(16);
        for(int i=0; i<row.getLastCellNum(); i++){
            re.add(BaseUtil.pure(row.getCell(i)));
        }
        return re;
    }
}
