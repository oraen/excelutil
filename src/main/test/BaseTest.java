import com.oraen.oxygen.common.util.JSON;
import com.oraen.oxygen.excelutil.ExcelUtil;
import entity.Cell;
import entity.Ent;
import entity.WUliao;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest {


    public static void main(String[] args) throws Exception {

   //     testMapsToWb();  //测试通过
  //      testEntitiesToWb();  //测试通过
  //      testGetTemplate();   //测试通过

  //      testWbToMaps();   //测试通过
        testWbToEntities();  //测试通过
  //      testGetHeads();   //测试成功



    }

    public static void testMapsToWb() throws IOException {

        List<Map<String, Object>> lm = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("名字", "威威");
        map.put("年龄", "15");
        map.put("爱好", "CS");
        lm.add((map));
        Map<String, Object> map2 = new HashMap<>();
        map2.put("名字", "京京");
        map2.put("年龄", "17");
        map2.put("爱好", "吃大屎");
        lm.add((map2));
        Map<String, Object> map3 = new HashMap<>();
        map3.put("名字", "凌凌");
        map3.put("年龄", "27");
        map3.put("爱好", "吃尿");
        lm.add((map3));
        List<String> heads = new ArrayList<>();
        heads.add("年龄");
        heads.add("名字");
        heads.add("爱好");
        heads.add("爱好");
        heads.add("爱好2");
        Workbook wb = ExcelUtil.getWorkbookFromMaps(heads, lm);
        wb.write(new FileOutputStream(new File("D:\\temporary\\kk.xlsx")));
    }

    public static void testEntitiesToWb() throws IOException {
        Ent ent = new Ent(50, "小萎", 1.78f, "阳痿", "牛人");
        Ent ent1 = new Ent(70, "小井", 1.88f, "健康", "老当益壮");
        Ent ent2 = new Ent(41, "小灵", 1.38f, "小儿麻痹症", "带货一哥");
        Ent ent3 = new Ent(50, "小蓝", 1.73f, "脑溢血", "-1s");
        List<Ent> es = new ArrayList<>();
        es.add(ent);
        es.add(ent1);
        es.add(ent2);
        es.add(ent3);

        List<String> heads = new ArrayList<>();
        heads.add("年龄");
        heads.add("名字");
        heads.add("身高");
        heads.add("身体情况");
        heads.add("伟文");
        Workbook wb = ExcelUtil.getWorkbookFromEntities(heads, es);
        wb.write(new FileOutputStream(new File("D:\\temporary\\kk.xlsx")));


    }


    public static void testGetTemplate() throws IOException {
        List<String> heads = new ArrayList<>();
        heads.add("a伟文");
        heads.add("asd");
        heads.add("2015");
        heads.add("阿松大 打算");
        heads.add("  阿松大  ");

        Workbook wb = ExcelUtil.getTemplate(heads);
        wb.write(new FileOutputStream(new File("D:\\temporary\\kk.xlsx")));

    }

    public static void testWbToMaps() throws IOException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(new File("D:\\temporary\\toData.xlsx"));
        List<Map<String, Object>> list = ExcelUtil.getMaps(wb);

        for(Map<String, Object> map :list){
            System.out.println(JSON.stringify(map));
        }

    }

    public static void testWbToEntities() throws IOException, InvalidFormatException {
//        Workbook wb = WorkbookFactory.create(new File("D:\\temporary\\toData.xlsx"));
//        List<WUliao> list = ExcelUtil.getEntities(wb, WUliao.class);

        Workbook wb = WorkbookFactory.create(new File("D:\\temporary\\data (3).xlsx"));
        List<Map<String, Object>> list0 = ExcelUtil.getMaps(wb);
        List<Cell> list = ExcelUtil.getEntities(wb, Cell.class);


        for(Map<String, Object> m :list0){
            System.out.println(JSON.stringify(m));
        }

        for(Cell wUliao :list){
            System.out.println(JSON.stringify(wUliao));
        }

    }


    public static void testGetHeads() throws Exception {
        Workbook wb = WorkbookFactory.create(new File("D:\\temporary\\toData.xlsx"));
        List<String> heads = ExcelUtil.getHeads(wb);
        System.out.println(JSON.stringify(heads));

    }

}

