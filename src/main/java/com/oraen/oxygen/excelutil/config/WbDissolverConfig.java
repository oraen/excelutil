package com.oraen.oxygen.excelutil.config;


import com.oraen.oxygen.excelutil.component.SauryConverter;
import com.oraen.oxygen.excelutil.component.WbDissolver;
import com.oraen.oxygen.excelutil.component.WbSEDissolver;
import com.oraen.oxygen.excelutil.component.saury.Saury;
import com.oraen.oxygen.excelutil.component.workbook.dissolver.StandEntitiesWbDissolver;
import com.oraen.oxygen.excelutil.component.workbook.dissolver.StandHeadsDissolver;
import com.oraen.oxygen.excelutil.component.workbook.dissolver.StandMapsWbDissolver;


import java.util.List;
import java.util.Map;

public class WbDissolverConfig {
    //顺序很重要 不然会循环引用
    public final static WbDissolver<List<String>> headsDissolver = new StandHeadsDissolver();

    public final static WbDissolver<List<Map<String, Object>>> mapsWbDissolver = new StandMapsWbDissolver();

    public final static WbSEDissolver entitiesWbDissolver = new StandEntitiesWbDissolver();

    static {

    }


}
