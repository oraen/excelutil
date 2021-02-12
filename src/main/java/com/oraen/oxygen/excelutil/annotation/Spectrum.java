package com.oraen.oxygen.excelutil.annotation;

import com.oraen.oxygen.excelutil.enumeration.Situation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Spectrum {
    Situation[] value();

}


