import com.oraen.oxygen.excelutil.dataUtil.BaseUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class GloTest {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Workbook a = WorkbookFactory.create(new File("D:\\work\\test11.xlsx"));

        Sheet s = a.getSheetAt(0);


        System.out.println(s.getPhysicalNumberOfRows());
        System.out.println(s.getLastRowNum());

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.println(i +" " + j + ":" + BaseUtil.get(s,i,j));
            }
            System.out.println("\n");
        }

    }
}
