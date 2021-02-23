import com.oraen.oxygen.excelutil.Responsibility.AssemblyLine;
import com.oraen.oxygen.excelutil.Responsibility.WorkNode;

import java.util.ArrayList;
import java.util.List;

public class TestAssemblyLine {

    public static void main(String[] args) {
        new TestAssemblyLine().test();

    }

    public void test(){
//        AssemblyLine<String> a = new AssemblyLine<String>();
//        a.addNode(new ObjWN());

        AssemblyLine<List<String>> a = new AssemblyLine<List<String>>();
        a.addNode(new LStringWN());
        a.addNode(new LJObjWN());
    //    a.addNode(new LObjWN());

    }
}

class StringWN implements WorkNode<String>{

    public String execute(String target, Object... params) throws Exception {
        return null;
    }
}

class ObjWN implements WorkNode<Object>{

    public Object execute(Object target, Object... params) throws Exception {
        return null;
    }
}

class LStringWN implements WorkNode<List<String>>{

    public List<String> execute(List<String> target, Object... params) throws Exception {
        return null;
    }
}

class LObjWN implements WorkNode<List<Object>>{

    public List<Object> execute(List<Object> target, Object... params) throws Exception {
        return null;
    }
}

class LJObjWN implements WorkNode<List<? extends Object>>{

    public List<? extends Object> execute(List<?> target, Object... params) throws Exception {
        return null;
    }
}
