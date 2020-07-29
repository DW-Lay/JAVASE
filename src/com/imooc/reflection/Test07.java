package com.imooc.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author Lincoln
 * @classname Test07
 * @description 练习反射操作注解
 * @params TODO
 * @return
 * @date 2020/7/10 20:22
 */
public class Test07 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.imooc.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解的value值
        Tablekuang tablekuang = (Tablekuang)c1.getAnnotation(Tablekuang.class);
        String value = tablekuang.value();
        System.out.println(value);

        // 获得类指定的注解
        Field f = c1.getDeclaredField("id");
        Fieldkuang annotation = f.getAnnotation(Fieldkuang.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }

}


@Tablekuang("db_student")
class Student2 {
    @Fieldkuang(columnName = "db_name",type = "int",length = 10)
    private int id;
    @Fieldkuang(columnName = "db_name",type = "varchar",length = 10)
    private String name;
    @Fieldkuang(columnName = "db_name",type = "int",length = 10)
    private int age;


    public Student2() {
    }

    public Student2(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface  Tablekuang{
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang{
    String columnName();
    String type();
    int length();
}
