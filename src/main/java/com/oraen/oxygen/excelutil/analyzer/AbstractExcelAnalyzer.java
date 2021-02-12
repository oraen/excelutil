package com.oraen.oxygen.excelutil.analyzer;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.exception.*;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public abstract class AbstractExcelAnalyzer {

    public abstract List<JSONObject> getEntities(Sheet sheet) throws UnexpectedException, RepetitiveDataException;

    public abstract<T> List<T> getEntities(Sheet sheet, Class<T> clazz) throws UnavailableTypeException, UnexpectedException, UnspecificException, RepetitiveDataException, BreakNecessityException ;




}
