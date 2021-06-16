package com.oraen.oxygen.excelutil;

import java.lang.annotation.*;

/**
 * author Corki
 * birthday 21.2.4
 * 标注实体类字段中与excel表中的字段相对应
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SheetField {

    /** 字段对应的excel字段名 */
    String value();

}

