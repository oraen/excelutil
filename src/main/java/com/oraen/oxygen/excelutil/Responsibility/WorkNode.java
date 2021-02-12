package com.oraen.oxygen.excelutil.Responsibility;

public interface WorkNode<T> {

    T execute(T target, Object... params) throws Exception;

}
