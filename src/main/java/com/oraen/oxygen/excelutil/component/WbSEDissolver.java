package com.oraen.oxygen.excelutil.component;

import com.oraen.oxygen.excelutil.component.workbook.dissolver.StandMapsWbDissolver;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public interface WbSEDissolver {

    <T> List<T> getEntities(Sheet sheet, Class<T> clazz);
}
