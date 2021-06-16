package com.oraen.oxygen.excelutil.component;

import com.oraen.oxygen.common.design.workstation.WorkNode;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public abstract class WbNode implements WorkNode<Workbook> {

    @Override
    public void execute(Workbook target) throws RuntimeException {
        modify(target.getSheetAt(0));
    }

    public abstract void modify(Sheet sheet);
}
