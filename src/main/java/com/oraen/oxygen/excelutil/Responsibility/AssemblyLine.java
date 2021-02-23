package com.oraen.oxygen.excelutil.Responsibility;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AssemblyLine<T> {

    private List<WorkNode<? super T>> assemblyLine = new ArrayList<WorkNode<? super T>> (8);

    public T work(T target, Object... params) throws Exception {
        T re = target;
        for(WorkNode<? super T> w : assemblyLine){
            re = (T)(w.execute(re, params));
        }

        return re;
    }

    public AssemblyLine<T> addNode(WorkNode<? super T> workNode){
        this.assemblyLine.add(workNode);
        return this;
    }


}
