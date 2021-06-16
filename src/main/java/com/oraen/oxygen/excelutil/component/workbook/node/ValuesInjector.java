package com.oraen.oxygen.excelutil.component.workbook.node;

import com.oraen.oxygen.excelutil.BaseUtil;
import com.oraen.oxygen.excelutil.component.Point;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Collection;

public class ValuesInjector extends ExplicitWbNode {

    Collection<?> values;

    public ValuesInjector(Collection<?> values){
        this.values = values;
    }

    public Collection<?> getValues() {
        return values;
    }

    public void setValues(Collection<?> values) {
        this.values = values;
    }



    @Override
    public void modify(Sheet sheet) {
        for(Object o :values){
            BaseUtil.set(sheet, point.getRow(), point.getLine(), o.toString());
            point.nextLine();
        }
    }
}
