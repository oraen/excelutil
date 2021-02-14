import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.excelutil.ExcelUtil;
import com.oraen.oxygen.excelutil.dataUtil.DataFormatUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestPro {
    private static void log(Object o){
        System.out.println(o);
    }


    private static void testGetE() throws IOException, InvalidFormatException {
        Workbook w = WorkbookFactory.create(new File("D:\\work\\excelutil\\测试excel\\示例样板.xlsx"));
        List<Ent> list = ExcelUtil.getEntities(w, Ent.class);

        List<JSONObject> data = ExcelUtil.getEntities(w);
     //   log(data);



        String show = DataFormatUtil.str(list);


        log(show);

    }

    private static void testSerE() throws IOException {
        Ent e1 = new Ent();
        e1.setAge(50);
        e1.setHeight(5.6f);
        e1.setName("小笨");
        e1.setQk("太笨了");

        Ent e2 = new Ent();
        e2.setName("大牛");

        List<Ent> l = new ArrayList<Ent>();
        l.add(e1);
        l.add(e2);

        List<String> head = new ArrayList<String>();
        head.add("身高");
        head.add("年龄");
        head.add("名字");

        Workbook wb = ExcelUtil.getWorkbook(head, l, Ent.class, true);

        wb.write(new FileOutputStream(new File("D:\\work\\excelutil\\测试excel\\生成.xlsx")));
    }
    public static void main(String[] args) throws IOException, InvalidFormatException {
       // testGetE();
        testSerE();

    }
}


/**
 * 不同类型的赋值  测试OK
 *  value OK， lack OK, necessity OK
 *  SheetEntity注解核对  OK
 */
