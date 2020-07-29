package com.imooc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Lincoln
 * @classname Test03
 * @description 练习获得类的信息
 * @params TODO
 * @return
 * @date 2020/7/10 11:15
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.imooc.reflection.Person");

        //获得类的名字
        System.out.println(c1.getName());  //获得包名和类名
        System.out.println(c1.getSimpleName()); // 获得类名

        // 获得类的属性
        System.out.println("=============================");
        Field[] fields = c1.getFields();  //只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("==============================");
        fields = c1.getDeclaredFields(); // 能够找到所有属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法
        System.out.println("============================");
        Method[] methods = c1.getMethods();   // 获得本类及其父类全部的public方法
        for (Method method : methods) {
            System.out.println("public的"+method);
        }

        methods = c1.getDeclaredMethods(); //获得本类所有的方法
        for (Method method : methods) {
            System.out.println("所有的"+method);
        }

        // 获得指定的方法
        System.out.println("==========================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得构造器
        System.out.println("============================");
        Constructor[] constructors = c1.getConstructors(); // 获得public的构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();   //获得全部的构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        // 获得指定的构造器
        System.out.println("===============================");
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println("#"+constructor);
    }

}
