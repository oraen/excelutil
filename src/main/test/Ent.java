import com.oraen.oxygen.excelutil.annotation.SheetEntity;
import com.oraen.oxygen.excelutil.annotation.SheetField;

@SheetEntity
public class Ent {
    @SheetField(value = "年龄", lack = "55")
    private int age;

    @SheetField("名字")
    public String name;

    @SheetField("身高")
    private Float height;

    @SheetField(value = "身体情况", lack = "良好")
    private String qk;

    private String alias;
}
