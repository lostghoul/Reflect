package com.sunshaogang;

import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) {
	// write your code here
        basicTest();
        oneTest();
    }

    private static void basicTest(){
        Class c = null;
        try {
            c = Class.forName("com.sunshaogang.Reflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method[] = c.getDeclaredMethods();
        for (Method m : method){
            show("method name = " + m.getName());
        }
    }

    private static void oneTest(){
        Object t = new Reflect();
        if (t instanceof Reflect){
            show("t 是 Reflect 的一个实例");
        }else {
            show("t 不是 Reflect 的一个实例");
        }
        Object s = new String();
        if (s instanceof Reflect){
            show("s 是 Reflect 的一个实例");
        }else {
            show("s 不是 Reflect 的一个实例");
        }
    }
    /****************************************************************************************************/
    private static void sayHello(){
        System.out.println("Hello, World!!");
    }

    public static void show(String s){
        System.out.println(s);
    }

    public void show(){

    }
    private void showp(){

    }
    private static void shows(){

    }


}
