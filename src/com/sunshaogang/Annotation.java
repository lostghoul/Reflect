package com.sunshaogang;

/**
 * Created by sunshaogang on 11/21/14.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyClassAnnotation(desc = "The class name", uri = "com.sunshaogang.Annotation", name = "Annotation")
public class Annotation {

    @MyFieldAnnotation(desc = "The class field", uri = "com.sunshaogang.Annotation.id")
    private int id;

    @MyConstructorAnnotation(desc = "The class constructor", uri = "com.sunshaogang.Annotation.MySample")
    public Annotation() {
    }

    public int getId() {
        return id;
    }

    @MyMethodAnnotation(desc = "The class method", uri = "com.sunshaogang.Annotation.setId")
    public void setId(int id) {
        this.id = id;
    }


    public static void main(String[] args) throws Exception {

        Class<Annotation> clazz = Annotation.class;

        //得到类注解
        MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyClassAnnotation.class);

        System.out.println(myClassAnnotation.desc() + " = " + myClassAnnotation.uri() + " : " + myClassAnnotation.name());

        //得到构造方法注解
        Constructor<Annotation> cons = clazz.getConstructor(new Class[]{});

        MyConstructorAnnotation myConstructorAnnotation = cons.getAnnotation(MyConstructorAnnotation.class);

        System.out.println(myConstructorAnnotation.desc() + " " + myConstructorAnnotation.uri());

        //获取方法注解
        Method method = clazz.getMethod("setId", new Class[]{int.class});

        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);

        System.out.println(myMethodAnnotation.desc() + " " + myMethodAnnotation.uri());
        //获取字段注解
        Field field = clazz.getDeclaredField("id");

        MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);

        System.out.println(myFieldAnnotation.desc() + " " + myFieldAnnotation.uri());
    }

}
