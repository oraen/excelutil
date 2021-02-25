import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.ExcelUtil;
import com.oraen.oxygen.excelutil.dataUtil.BaseUtil;
import entity.ProcessData;
import entity.StockData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class GloTest {

    public static void testUse() throws IOException, InvalidFormatException {
        Workbook a = WorkbookFactory.create(new File("C:\\Users\\Corki\\Documents\\WeChat Files\\wxid_biadxph3wznu22\\FileStorage\\File\\2021-02\\委外MES数据模板分档入库数据 - 副本.xls"));
        Sheet s = a.getSheetAt(0);
        System.out.println(s.getPhysicalNumberOfRows());
        System.out.println(s.getLastRowNum());
        List<StockData> l = ExcelUtil.getEntities(a, StockData.class);
        System.out.println(l);
    }

    public static void testMAP() throws IOException, InvalidFormatException {
        Workbook a = WorkbookFactory.create(new File("C:\\Users\\Corki\\Documents\\WeChat Files\\wxid_biadxph3wznu22\\FileStorage\\File\\2021-02\\委外MES数据模板分档入库数据 - 副本.xls"));
        Sheet s = a.getSheetAt(0);
        System.out.println(s.getPhysicalNumberOfRows());
        System.out.println(s.getLastRowNum());
        List<JSONObject> l = ExcelUtil.getEntities(a);
        System.out.println(l);
        System.out.println(l.size());
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        testMAP();

    }
}
