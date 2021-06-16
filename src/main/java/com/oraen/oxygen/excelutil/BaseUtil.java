package com.oraen.oxygen.excelutil;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class BaseUtil {

    public static void unify(Cell cell){
        cell.setCellType(CellType.STRING);
    }

    public static void set(Sheet sheet, int row, int line, Object value){
        Cell cell = getCell(sheet, row, line);
        String sValue = value == null? "" : value.toString();
        cell.setCellValue(sValue);
    }

    public static Cell getCell(Sheet sheet, int row, int line) {
        Row theRow = sheet.getRow(row);
        if(theRow == null){
            theRow = sheet.createRow(row);
        }

        Cell theLine = theRow.getCell(line);
        if(theLine == null){
            theLine = theRow.createCell(line);
        }

        unify(theLine);
        return theLine;
    }

    public static String get(Sheet sheet, int row, int line) {
        return get(getCell(sheet, row, line));
    }

    public static String get(Cell cell){
        if(cell == null){
            return null;
        }
        unify(cell);
        return cell.getStringCellValue().trim();
    }

    public static String pure(Cell cell){
        return StringUtils.deleteWhitespace(get(cell));
    }

    public static int rowNum(Sheet sheet){
        int All = sheet.getLastRowNum() + 1 ;
        int i, j;
        for(i=0; i<All; i++){
            Row row = sheet.getRow(i);
            int cellNum = row.getLastCellNum() +1;
            for(j=0; j<cellNum; j++){
                Cell cell = row.getCell(j);
                String value = get(cell);
                if(! StringUtils.isBlank(value)){
                    break;
                }
            }

            //如果发现j == cellNum 则说明这一行是空的 返回
            if(j >= cellNum){
                break;
            }

        }
        return i;
    }

    public static int lineNum(Sheet sheet){
        return sheet.getRow(0).getLastCellNum();
    }

}
