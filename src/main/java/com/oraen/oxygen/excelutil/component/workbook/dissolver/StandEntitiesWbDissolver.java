package com.oraen.oxygen.excelutil.component.workbook.dissolver;

import com.oraen.oxygen.excelutil.component.CitrusConverter;
import com.oraen.oxygen.excelutil.component.WbDissolver;
import com.oraen.oxygen.excelutil.component.WbSEDissolver;
import com.oraen.oxygen.excelutil.config.CitrusConfig;
import com.oraen.oxygen.excelutil.config.WbDissolverConfig;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;

public class StandEntitiesWbDissolver implements WbSEDissolver {

    WbDissolver<List<Map<String, Object>>> standMapsWbDissolve = WbDissolverConfig.mapsWbDissolver;

    CitrusConverter citrusConverter = CitrusConfig.citrus;

    @Override
    public <T> List<T> getEntities(Sheet sheet, Class<T> clazz) {
        List<Map<String, Object>> maps = standMapsWbDissolve.getData(sheet);
        return citrusConverter.create(maps, clazz);
    }
}
