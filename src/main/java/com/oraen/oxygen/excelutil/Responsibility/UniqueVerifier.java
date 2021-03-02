package com.oraen.oxygen.excelutil.Responsibility;

import com.oraen.oxygen.excelutil.annotation.SheetField;
import com.oraen.oxygen.excelutil.dataUtil.CommonUtil;
import com.oraen.oxygen.excelutil.exception.AccessingEmptyException;
import com.oraen.oxygen.excelutil.exception.BreakUniqueException;
import com.oraen.oxygen.excelutil.exception.UnexpectedException;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UniqueVerifier implements WorkNode<List<?>>  {

    private static UniqueVerifier uniqueVerifier = null;

    public static UniqueVerifier getInstance(){
        if(uniqueVerifier == null){
            synchronized (UniqueVerifier.class){
                if(uniqueVerifier == null){
                    uniqueVerifier = new UniqueVerifier();
                }
            }
        }

        return uniqueVerifier;
    }
    private  UniqueVerifier(){}

    public List<?> execute(List<?> target, Object... params) throws BreakUniqueException, UnexpectedException {

        try{
            if(target.size() > 0){
                BreakUniqueException be = new BreakUniqueException();
                Field[] fields = CommonUtil.getContentType(target).getDeclaredFields();

                for(Field field : fields){
                    SheetField sf = field.getAnnotation(SheetField.class);
                    if(sf != null){
                        field.setAccessible(true);
                        if(sf.unique()){
                            Set<Object> set = new HashSet<Object>();
                            Set<Object> illicit = new HashSet<Object>();
                            for(Object o : target){
                                Object value = field.get(o);
                                if(! set.add(value)){
                                    illicit.add(value);
                                }
                            }

                            if(illicit.size() > 0){
                                be.addDetail(field.toGenericString(), illicit);
                            }

                        }
                    }
                }

                if(be.getDetail().size() > 0){
                    throw be;
                }
            }

            return target;

        }catch (AccessingEmptyException e){
            e.printStackTrace();
            throw new UnexpectedException("执行出错 传入数组意外为0但是并没有捕获");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new UnexpectedException("通过反射为字段设值时出错  意外地无访问权限");
        }


    }
}
