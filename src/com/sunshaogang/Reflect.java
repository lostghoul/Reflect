package com.sunshaogang;

import java.lang.reflect.*;

public class Reflect {

    private int a;
    private int b;

    public Reflect(){

    }

    private Reflect(int a, int b){
        this.a = a;
        this.b = b;
    }

    private Reflect(int a, long b){

    }
    public static void main(String[] args) {
	// write your code here
        basicTest();
        oneTest();
        twoTest();
        threeTest();
        fourTest();
        fiveTest();
        sixTest();
    }



    /**
     * 获得方法名
     */
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

    /**
     * 对象类型
     */
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

    /**
     * 获取对象实例
     */
    private static void twoTest(){
        Class c = null;
        try {
            c = Class.forName("com.sunshaogang.Reflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean b1 = c.isInstance(new Integer(37));
        show("b1 = " + b1);
        boolean b2 = c.isInstance(new Reflect());
        show("b2 = " + b2);

    }

    /**
     * 获得类的属性、名称和参数
     */
    private static void threeTest(){
        Class c = null;
        try {
            c = Class.forName("com.sunshaogang.Reflect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons){
            show("Modifier = " + Modifier.toString(con.getModifiers()));//该构造方法的前缀修饰符
            show("structor name = " + con.getName());
            Class[] types = con.getParameterTypes();//构造方法的参数
            for (Class cl : types){
                show("cl = " + cl.getName());
            }
        }
    }

    /**
     * 通过使用指定的构造函数 获取类的对象
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private static void fourTest() {
        try {
            Class cls = Class.forName("com.sunshaogang.Reflect");
            //两个参数的类型
            Class types[] = new Class[2];
            types[0] = Integer.TYPE;
            types[1] = Integer.TYPE;
            //获取带两个参数的构造方法
            Constructor ct = cls.getDeclaredConstructor(types);
            //参数列表
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(2);
            arglist[1] = new Integer(30);
            //obj 就是通过制定构造方法获取到的对象。
            Object obj = ct.newInstance(arglist);
            show("obj = " + obj.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改属性的值
     */
    private static void fiveTest() {
        try {
            Class cls = Class.forName("com.sunshaogang.Reflect");
            //取属性对象
            Field fld = cls.getDeclaredField("a");
            //新建一个实例
            Object obj = cls.newInstance();
            //未设置值之前
            show("a = " + ((Reflect) obj).a);
            //调用实例的set方法设置属性值
            fld.setInt(obj, 99);
            //设置之后的值
            show("a = " + ((Reflect) obj).a);
        } catch (SecurityException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 执行带多个参数的方法
     */
    private static void sixTest() {
        try {
            Class cls = Class.forName("com.sunshaogang.Reflect");
            Class[] types = new Class[2];
            types[0] = Integer.TYPE;
            types[1] = Integer.TYPE;
            //查找add方法
            Method method = cls.getMethod("add", types);
            //创建对象实例
            Object obj = cls.newInstance();
            //然后调用它的方法
            //先参数值j=method
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(40);
            Object retob = method.invoke(obj, arglist);
            Integer retval = (Integer) retob;
            System.out.println(retval);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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

    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String toString(){
        return "this is Reflect class p1 = " + a + " | p2 = " + b;
    }
}
