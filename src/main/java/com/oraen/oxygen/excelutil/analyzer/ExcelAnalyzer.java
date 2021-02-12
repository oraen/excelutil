package com.oraen.oxygen.excelutil.analyzer;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.dataUtil.BaseUtil;
import com.oraen.oxygen.excelutil.dataUtil.DataConvertUtil;
import com.oraen.oxygen.excelutil.exception.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.LinkedList;
import java.util.List;

public class ExcelAnalyzer extends AbstractExcelAnalyzer {

    /**
     * 简单暴力的方法 把excel表格转化成map的列表 未测试
     * @param sheet 目标sheet
     * @return 列表
     * @throws Exception
     */
    public List<JSONObject> getEntities(Sheet sheet) throws RepetitiveDataException {
        List<JSONObject> list = new LinkedList<JSONObject>();
        int size = sheet.getLastRowNum() + 1;    //excel的记录数
        List<String> head = BaseUtil.getHead(sheet);
        int itemNum = head.size();

        for(int i=1; i<size; i++){
            JSONObject unit = new JSONObject();
            for(int j=0; j<itemNum; j++){
                String value= BaseUtil.get(sheet, i, j);
                unit.put(head.get(j), value);
            }

            list.add(unit);
        }

        return list;
    }


    //通过sheet获取对应类的实例列表
    public<T> List<T> getEntities(Sheet sheet, Class<T> clazz) throws UnavailableTypeException, UnspecificException, RepetitiveDataException, BreakNecessityException {

        //BaseUtil.check(sheet, clazz);

        List<JSONObject> SheetMap = getEntities(sheet);

        List<T> re = DataConvertUtil.transform(SheetMap, clazz);

        return re;

    }




}
