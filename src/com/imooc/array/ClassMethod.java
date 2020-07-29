package com.imooc.array;

/**
 * @author Lincoln
 * @classname ClassMethod
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2020/6/29 21:38
 */
public class ClassMethod {
    public static void main(String[] args) {

        ClassMethod classMethod = new ClassMethod();
        classMethod.testa();
    }

    public  void testa() {
        testb();
    }

    public static void testb() {
        System.out.println("testb");
    }
}
