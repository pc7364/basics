package cn.pc.basics.generics;

/**
 * @Desc
 * @Author pc
 * @Date 2024/4/10 16:50
 */
public class Demo1 {

    public static void main(String[] args) {

        // 使用String为泛型类型
        Info<String> i = new Info<String>() ;
        // 设置内容
        i.setVar("MLDN") ;
        //fun(i); //把String泛型类型的i对象传递给Object泛型类型的temp。  编辑报错
        ////////////////////    ===================================     ////////////////////
        fun1(i);

        ////////////////////    ===================================     ////////////////////
        Info<Integer> i1 = new Info<Integer>() ;        // 声明Integer的泛型对象
        Info<Float> i2 = new Info<Float>() ;            // 声明Float的泛型对象
        i1.setVar(30) ;                                    // 设置整数，自动装箱
        i2.setVar(30.1f) ;                                // 设置小数，自动装箱
        fun2(i1) ;
        fun2(i2) ;

        ////////////////////    ===================================     ////////////////////
        Info<String> i12 = new Info<String>() ;        // 声明String的泛型对象
        Info<Object> i22 = new Info<Object>() ;        // 声明Object的泛型对象
        i12.setVar("hello") ;
        i22.setVar(new Object()) ;
        fun3(i12) ;
        fun3(i22) ;
    }

    public static void fun(Info<Object> temp) {        // 接收Object泛型类型的Info对象
        System.out.println("内容：" + temp);
    }

    public static void fun1(Info<?> temp) {        // 接收Object泛型类型的Info对象
        System.out.println("内容：" + temp);
    }

    public static void fun2(Info<? extends Number> temp) {        // 接收Object泛型类型的Info对象
        System.out.println("内容：" + temp);
    }

    public static void fun3(Info<? super String> temp){    // 只能接收String或Object类型的泛型，String类的父类只有Object类
        System.out.print(temp + "、") ;
        System.out.println();
    }
}
