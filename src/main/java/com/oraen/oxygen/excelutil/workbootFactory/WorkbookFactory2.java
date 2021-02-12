package com.oraen.oxygen.excelutil.workbootFactory;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.dataUtil.BaseUtil;
import com.oraen.oxygen.excelutil.dataUtil.DataConvertUtil;
import com.oraen.oxygen.excelutil.exception.CheckFailException;
import com.oraen.oxygen.excelutil.exception.UnexpectedException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkbookFactory2 {

    public static Workbook createWorkbook(InputStream is, String excelFileName) throws IOException {
        if (excelFileName.endsWith(".xls")) {
            return new HSSFWorkbook(is);
        } else if (excelFileName.endsWith(".xlsx")) {
            return new XSSFWorkbook(is);
        }
        return null;
    }




    public Workbook getTemplate(List<String> head, final boolean counter) {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        Row row = sheet.createRow(0);

        int j=0;
        if(counter){
            Cell cell = row.createCell(j);
            cell.setCellValue("序号");

            j++;
        }
        for(String field : head){
            Cell cell = row.createCell(j);
            cell.setCellValue(field);
            j++;
        }
        return wb;
    }

    public Workbook getTemplate(List<String> head) {
        return getTemplate(head, false);
    }


    public<T> Workbook getTemplate(Class<T> clazz, final boolean counter) throws CheckFailException {

        List<String> fields = BaseUtil.getHead(clazz);
        return getTemplate(fields, counter);

    }

    public<T> Workbook getTemplate(Class<T> clazz) throws CheckFailException {
        return getTemplate(clazz, false);
    }





    public<T> Workbook getWorkbook(List<String> heads, List<T> list, Class<T> clazz, final boolean counter){
        List<JSONObject> mapList = DataConvertUtil.transform(list);
        return getWorkbook(heads, mapList, counter);

    }

    public<T> Workbook getWorkbook(List<String> heads, List<T> list, Class<T> clazz) {
        return getWorkbook(heads, list, clazz, false);
    }




    public Workbook getWorkbook(List<String> heads, List<JSONObject> list, final boolean counter) {
        Workbook wb = getTemplate(heads, counter);
        Sheet sheet = wb.getSheetAt(0);

        //设置文档体
        int i=1;
        for(Map<String,Object> unit : list){
            Row bodyRow = sheet.createRow(i);
            int j1=0;  //表中的位置指针
            int j2=0;  //对应头的位置指针
            if(counter){
                Cell cell = bodyRow.createCell(j1);
                cell.setCellValue(String.valueOf(i++));
                j1++;
            }
            for(; j2<heads.size(); j1++,j2++){
                Cell cell = bodyRow.createCell(j1);
                cell.setCellValue((String)unit.get(heads.get(j2)));
            }
        }
        return wb;

    }

    public Workbook getWorkbook(List<String> heads, List<JSONObject> list) {
        return getWorkbook(heads, list, false);
    }


    public Workbook getWorkbook(List<JSONObject> list, final boolean counter) {

        JSONObject reference = list.get(0);

        List<String> heads = new ArrayList<String>(20);

        heads.addAll(reference.keySet());

        return getWorkbook(heads,list, counter);
    }


    public Workbook getWorkbook(List<JSONObject> list) {
        return getWorkbook(list, false);
    }


    public<T> Workbook getWorkbook(List<T> list, Class<T> clazz, final boolean counter) throws CheckFailException {
        if(list.size() == 0){
            return getTemplate(clazz,counter);
        }
        List<String> heads = BaseUtil.getHead(clazz);
        List<JSONObject> mapList = DataConvertUtil.transform(list);
        return getWorkbook(heads, mapList, counter);
    }


    public<T> Workbook getWorkbook(List<T> list, Class<T> clazz) throws CheckFailException {
        return getWorkbook(list, clazz, false);
    }


}
