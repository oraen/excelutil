package com.oraen.oxygen.excelutil.component;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public interface WbDissolver<T> {

    T getData(Sheet sheet);

}
