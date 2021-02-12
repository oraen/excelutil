package com.oraen.oxygen.excelutil.dataUtil;

import com.alibaba.fastjson.JSON;
import com.oraen.oxygen.excelutil.exception.UnexpectedException;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class DataFormatUtil {

    public static String visualization(Number number){
        return String.valueOf(number);
    }

    public static String visualization(String str){
        return "\"" + str + "\"";
    }


    public static String visualization(Map<String, ? extends Object> map){
        StringBuilder sb = new StringBuilder();
        for(String k : map.keySet()){
            sb.append(k);
            sb.append(" : ");
            Object o = map.get(k);
            if(o instanceof Number){
                sb.append(visualization((Number)o));
            }else if(o instanceof String){
                sb.append(visualization((String)o));
            }else if(o instanceof Field){
                sb.append(((Field) o).toGenericString());
            }else{
                sb.append(o.toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static String visualization(Collection<Object> col){
        StringBuilder sb = new StringBuilder();
        for(Object o : col){
            if(o instanceof Number){
                sb.append(visualization((Number)o));
            }else if(o instanceof String){
                sb.append(visualization((String)o));
            }
            sb.append(" ");
        }

        return sb.toString();
    }


    public static String str(Object o) {
        try{
            StringBuilder sb = new StringBuilder();
            Field[] fields = o.getClass().getDeclaredFields();
            sb.append("{ ");

            for(Field f : fields){
                f.setAccessible(true);
                sb.append("\"");
                sb.append(f.getName());
                sb.append("\":\"");
                sb.append(f.get(o));
                sb.append("\", ");
            }

            sb.delete(sb.length()-2, sb.length());
            sb.append(" }");
            return sb.toString();
        }catch (IllegalAccessException e){
            throw new UnexpectedException("设置值失败");
        }

    }

    public static String str(Collection<?> col){
        StringBuilder sb = new StringBuilder();
        for(Object o : col){
            sb.append(str(o));
            sb.append("\n");
        }
        return sb.toString();
    }
}
