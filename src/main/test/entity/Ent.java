package entity;

import com.oraen.oxygen.excelutil.SheetEntity;
import com.oraen.oxygen.excelutil.SheetField;

@SheetEntity
public class Ent {
    @SheetField(value = "年龄")
    private int age;

    @SheetField("名字")
    public String name;

    @SheetField("身高")
    private Float height;

    @SheetField(value = "身体情况")
    private String qk;

    private String alias;

    public Ent(int age, String name, Float height, String qk, String alias) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.qk = qk;
        this.alias = alias;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getQk() {
        return qk;
    }

    public void setQk(String qk) {
        this.qk = qk;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
