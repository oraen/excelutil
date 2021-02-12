package com.oraen.oxygen.excelutil.annotation;

import com.oraen.oxygen.excelutil.enumeration.Situation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SheetField {

    @Spectrum(Situation.CREATE_TIME)
    String value();

    @Spectrum(Situation.CHECK_TIME)
    String norm() default ".*";

    @Spectrum(Situation.CHECK_TIME)
    boolean unique() default false;

    @Spectrum(Situation.CREATE_TIME)
    boolean necessity() default  false;

    @Spectrum(Situation.CREATE_TIME)
    String lack() default "";

}

