import java.lang.reflect.Field;

public class TestFieldUse {
    public String asd;

    public static void main(String[] args) throws NoSuchFieldException {
        Field a = TestFieldUse.class.getField("asd");
        System.out.println(a.getName());
        System.out.println(a.toGenericString());
        System.out.println(a.toString());
    }
}
