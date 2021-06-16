package com.oraen.oxygen.excelutil.component.workbook.dissolver;

import com.oraen.oxygen.excelutil.BaseUtil;
import com.oraen.oxygen.excelutil.component.WbDissolver;
import com.oraen.oxygen.excelutil.config.WbDissolverConfig;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

public class StandMapsWbDissolver implements WbDissolver<List<Map<String, Object>>> {

    private WbDissolver<List<String>> headsGetter = WbDissolverConfig.headsDissolver;

    @Override
    public List<Map<String, Object>> getData(Sheet sheet) {
        List<Map<String, Object>> re = new ArrayList<>();
        List<String> heads = headsGetter.getData(sheet);
        int rowNum = BaseUtil.rowNum(sheet);
        int lineNum = heads.size();
        for(int i=1; i<rowNum; i++){
            Map<String, Object> map = new HashMap<>(16);
            for(int j=0; j<lineNum; j++){
                map.put(heads.get(j), BaseUtil.get(sheet, i, j));
            }
            re.add(map);
        }

        return re;
    }

}
