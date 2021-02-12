package com.oraen.oxygen.excelutil.dataUtil;

import com.oraen.oxygen.excelutil.Responsibility.UniqueChecker;
import com.oraen.oxygen.excelutil.annotation.SheetEntity;
import com.oraen.oxygen.excelutil.annotation.SheetField;
import com.oraen.oxygen.excelutil.exception.AccessingEmptyException;
import com.oraen.oxygen.excelutil.exception.CheckFailException;
import com.oraen.oxygen.excelutil.exception.RepetitiveDataException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;
import java.util.*;

public class BaseUtil {

    public static boolean unify(Cell cell){
        if(cell == null){
            return false;
        }

        cell.setCellType(CellType.STRING);
        return true;
    }


    public static void set(Sheet sheet, int row, int line, String value) throws AccessingEmptyException {
        Cell cell = sheet.getRow(row).getCell(line);

        if(unify(cell)){
            cell.setCellValue(value);
        }else{
            throw new AccessingEmptyException ("不存在的单元格");
        }
    }


    public static String get(Sheet sheet, int row, int line) {
        Row theRow = sheet.getRow(row);
        if(theRow != null){
            Cell cell = sheet.getRow(row).getCell(line);
            return get(cell);
        }else{
            return "";
        }

    }


    public static String get(Cell cell){
        if(unify(cell)){
            return StringUtils.trim(cell.getStringCellValue());
        }
        return "";
    }

    public static String pure(Cell cell){
        if(unify(cell)){
            return StringUtils.deleteWhitespace(cell.getStringCellValue());
        }
        return null;
    }

    /**
     * 获取excel的的字段map表 字段存储在key中 位置存在value中
     * @param sheet 目标sheet
     * @return 字段map表
     * @throws Exception
     */
    public static Map<String, Integer> getItem(Sheet sheet) throws RepetitiveDataException {

        List<String> head = getHead(sheet);
        int itemNum = 0;
        Map<String, Integer> itemMap = new HashMap<String,Integer>();

        for(String line : head){
            itemMap.put(line, itemNum);
            itemNum ++;
        }


        return itemMap;
    }

    public static<T> List<String> getHead(Class<T> clazz) throws CheckFailException {
        check(clazz);
        List<String> re = new ArrayList<String>(20);
        Field[] entityAllFields = clazz.getDeclaredFields();

        for(Field entityField : entityAllFields){
            SheetField sf = entityField.getAnnotation(SheetField.class);
            if(sf != null){
                String value = sf.value();
                re.add(value);
            }
        }

        return re;
    }

    /**
     * 获取文档头
     * @param sheet 目标sheet
     * @return 属性列表
     * @throws Exception
     */
    public static List<String> getHead(Sheet sheet) throws RepetitiveDataException {
        int itemNum = 0;
        Row row = sheet.getRow(0);
        List<String> head = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        while(StringUtils.isNotBlank(get(row.getCell(itemNum)))){
            String revised = pure(row.getCell(itemNum));
            head.add(revised);
            itemNum ++;
        }

        UniqueChecker.getInstance().execute(head);

        return head;


    }




    public static<T> void check(Class<T> clazz) throws CheckFailException{
        if(clazz.getAnnotation(SheetEntity.class) == null){
            throw new CheckFailException("目标转化实体类 "+clazz.getName()+" 没有标上SheetEntity注解");
        }
    }

    public static void check(Object obj) throws CheckFailException{
        check(obj.getClass());
    }

    public static<T> void check(Sheet sheet, Class<T> clazz) throws CheckFailException, RepetitiveDataException {
        //检查注解
        check(clazz);

        Field[] entityFields = clazz.getDeclaredFields();

        //检查字段注解的合法性
        Map<String, Integer> item = getItem(sheet);
        for(Field entityField : entityFields){
            SheetField sf = entityField.getAnnotation(SheetField.class);
            if(sf != null){
                if(! item.containsKey(sf.value())){
                    throw new CheckFailException("Sheet文档中不存在的列 "+ sf.value());
                }
            }
        }

    }


}
