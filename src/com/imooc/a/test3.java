package com.imooc.a;

import java.lang.reflect.Type;

/**
 * @program: HelloWorld
 * @description: 测试同一包内
 * @author: 董明林
 * @date: 2021-07-12 10:05:48
 */
public class test3 {

    public static void main(String[] args) {
        teatA teatA = new teatA();
        teatA.test();
        teatA.test2();
        Integer a  = 128;
        Class<Integer> integerClass = Integer.class;



    }
}