package com.sunshaogang;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Created by sunshaogang on 11/19/14.
 * 构造方法注解
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface MyConstructorAnnotation {

    String uri();
    String desc();
}