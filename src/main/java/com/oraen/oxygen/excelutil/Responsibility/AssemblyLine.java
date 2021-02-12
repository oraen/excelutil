package com.oraen.oxygen.excelutil.Responsibility;

import java.util.ArrayList;
import java.util.List;


public class AssemblyLine<T> {

    private List<WorkNode<T>> assemblyLine = new ArrayList<WorkNode<T>> (8);

    public T work(T target, Object... params) throws Exception {
        T re = target;
        for(WorkNode<T> w : assemblyLine){
            re = w.execute(re, params);
        }

        return re;
    }

    public AssemblyLine<T> addNode(WorkNode<T> workNode){
        this.assemblyLine.add(workNode);
        return this;
    }


}
