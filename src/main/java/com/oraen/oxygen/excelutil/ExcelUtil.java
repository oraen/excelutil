package com.oraen.oxygen.excelutil;

import com.oraen.oxygen.excelutil.component.WbCreator;
import com.oraen.oxygen.excelutil.component.WbDissolver;
import com.oraen.oxygen.excelutil.component.WbSEDissolver;
import com.oraen.oxygen.excelutil.component.workbook.creator.EntitiesWbCreator;
import com.oraen.oxygen.excelutil.component.workbook.creator.StandMapsWbCreator;
import com.oraen.oxygen.excelutil.component.workbook.creator.StandTemplateCreator;
import com.oraen.oxygen.excelutil.config.WbDissolverConfig;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;



public class ExcelUtil {

    private static WbDissolver<List<Map<String, Object>>> mapsWbDissolver = WbDissolverConfig.mapsWbDissolver;

    private static WbDissolver<List<String>> headsDissolver = WbDissolverConfig.headsDissolver;

    private static WbSEDissolver entitiesWbDissolver = WbDissolverConfig.entitiesWbDissolver;


    public static List<Map<String, Object>> getMaps(Workbook workbook) {
        return mapsWbDissolver.getData(workbook.getSheetAt(0));
    }


    public static<T> List<T> getEntities(Workbook workbook, Class<T> clazz) {
        return entitiesWbDissolver.getEntities(workbook.getSheetAt(0), clazz);

    }


    public static Workbook getWorkbookFromEntities(List<String> heads, List<?> list) {
        WbCreator entitiesWbCreator = new EntitiesWbCreator(heads, list);
        return entitiesWbCreator.creator();
    }


    public static Workbook getWorkbookFromMaps(List<String> heads, List<Map<String, Object>> list) {
        WbCreator mapsWbCreator = new StandMapsWbCreator(heads, list);
        return mapsWbCreator.creator();
    }


    public static Workbook getTemplate(List<String> head) {
        return new StandTemplateCreator(head).creator();
    }

    public static List<String> getHeads(Workbook workbook) {
        return headsDissolver.getData(workbook.getSheetAt(0));
    }

    public static void main(String[] args) {

    }


}
