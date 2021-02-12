package com.oraen.oxygen.excelutil.Responsibility;

import com.oraen.oxygen.excelutil.exception.RepetitiveDataException;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class UniqueChecker implements WorkNode<Collection<?>> {

    private static UniqueChecker uniqueChecker = null;

    public static UniqueChecker getInstance(){
        if(uniqueChecker == null){
            synchronized (UniqueChecker.class){
                if(uniqueChecker == null){
                    uniqueChecker = new UniqueChecker();
                }
            }
        }

        return uniqueChecker;
    }

    private UniqueChecker(){}

    public Collection<?> execute(Collection<?> target, Object... arg) throws RepetitiveDataException {
        Set<Object> set = new HashSet<Object>(target.size() *5/3 +1);  //保证容量*0.75后的int化值不会小于或者等于原大小导致扩容
        Set<Object> record = new HashSet<Object>();
        for(Object obj : target){
            if(!set.add(obj)){
                record.add(obj);
            }
        }

        if(record.size() > 0){
            throw new RepetitiveDataException(record);
        }

        return target;


    }
}
