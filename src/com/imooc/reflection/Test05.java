package com.imooc.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lincoln
 * @classname Test05
 * @description 分析反射和正常调用的性能问题
 * @params TODO
 * @return
 * @date 2020/7/10 17:47
 */
public class Test05 {

    public static void test01(){
        long startTime = System.currentTimeMillis();

        Person person = new Person();
        for (int i = 0; i < 10_0000_0000; i++) {
            person.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行10亿次:"+(endTime-startTime)+"ms");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Person person = new Person();
        Class c1 = person.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            getName.invoke(person, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式执行10亿次:"+(endTime-startTime)+"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Person person = new Person();
        Class c1 = person.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            getName.invoke(person, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式关闭检测执行10亿次:"+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
