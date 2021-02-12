package com.oraen.oxygen.excelutil;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.analyzer.AbstractExcelAnalyzer;
import com.oraen.oxygen.excelutil.analyzer.ExcelAnalyzer;
import com.oraen.oxygen.excelutil.dataUtil.BaseUtil;
import com.oraen.oxygen.excelutil.workbootFactory.WorkbookFactory2;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.util.List;


public class ExcelUtil {

    private static AbstractExcelAnalyzer excelAnalyzer = new ExcelAnalyzer();

    private static WorkbookFactory2 workbookFactory2 = new WorkbookFactory2();

    public static List<JSONObject> getEntities(Workbook workbook) {
        try{
            return excelAnalyzer.getEntities(workbook.getSheetAt(0));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static<T> List<T> getEntities(Workbook workbook, Class<T> clazz) {
        try{
            BaseUtil.check(workbook.getSheetAt(0), clazz);
            return excelAnalyzer.getEntities(workbook.getSheetAt(0), clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public static<T> Workbook getWorkbook(List<String> heads, List<T> list, Class<T> clazz, final boolean counter) {
        try{
            return workbookFactory2.getWorkbook(heads, list, clazz, counter);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static<T> Workbook getWorkbook(List<String> heads, List<T> list, Class<T> clazz) {
        try{
            return workbookFactory2.getWorkbook(heads, list, clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }




    public static Workbook getWorkbook(List<String> heads, List<JSONObject> list, final boolean counter) {

        return workbookFactory2.getWorkbook(heads, list, counter);
    }

    public static Workbook getWorkbook(List<String> heads, List<JSONObject> list) {

        return workbookFactory2.getWorkbook(heads, list);
    }


    public static Workbook getWorkbook(List<JSONObject> list, final boolean counter) {

        return workbookFactory2.getWorkbook(list, counter);
    }


    public static Workbook getWorkbook(List<JSONObject> list) {
        return workbookFactory2.getWorkbook(list);
    }


    public static<T> Workbook getWorkbook(List<T> list, Class<T> clazz, final boolean counter) {
        try{
            return workbookFactory2.getWorkbook(list, clazz, counter);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static<T> Workbook getWorkbook(List<T> list, Class<T> clazz) {
        try{
            return  workbookFactory2.getWorkbook(list, clazz);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static<T> Workbook getTemplate(List<String> head) {
        return workbookFactory2.getTemplate(head);
    }

    public static<T> Workbook getTemplate(List<String> head, boolean counter) {
        return workbookFactory2.getTemplate(head, counter);
    }


}
