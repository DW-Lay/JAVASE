package com.imooc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lincoln
 * @classname Test04
 * @description 练习通过反射动态的创建对象
 * @params TODO
 * @return
 * @date 2020/7/10 12:31
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.imooc.reflection.Person");

        //构造一个对象
        Person person = (Person) c1.newInstance(); // 本质上调用了类的无参构造器
        System.out.println(person);

        // 通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class); //通过有参构造器，先拿出构造器，再往里塞值
        Person person1 = (Person) constructor.newInstance("董明林", 1, 1);
        System.out.println(person1);

        //通过反射调用普通方法
        Person person2 = (Person) c1.newInstance();
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        // invoke:激活的意思
        // (对象，“方法的值”)
        setName.invoke(person2,"董明林");
        System.out.println(person2.getName());


        //通过反射操作属性
        Person person3  = (Person) c1.newInstance();
        // 返回一个属性
        Field name = c1.getDeclaredField("name");

        // 不能直接操作私有属性，需要关闭程序的安全监测，属性或者方法的setAccessible(true)
        name.setAccessible(true); //
        name.set(person3,"李四");
        System.out.println(person3.getName());


    }
}
