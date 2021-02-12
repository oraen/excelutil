import com.oraen.oxygen.excelutil.ExcelUtil;
import com.oraen.oxygen.excelutil.dataUtil.DataFormatUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestPro {
    private static void log(Object o){
        System.out.println(o);
    }


    private static void testGetE() throws IOException, InvalidFormatException {
        Workbook w = WorkbookFactory.create(new File("D:\\work\\excelutil\\测试excel\\示例样板.xlsx"));
        List<Ent> list = ExcelUtil.getEntities(w, Ent.class);


        String show = DataFormatUtil.str(list);


        log(show);

    }
    public static void main(String[] args) throws IOException, InvalidFormatException {
        testGetE();

    }
}


/**
 * 不同类型的赋值  测试OK
 *  value OK， lack OK, necessity OK
 *  SheetEntity注解核对  OK
 */
