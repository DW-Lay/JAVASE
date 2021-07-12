package com.imooc.a;

/**
 * @program: HelloWorld
 * @description: 测试protected修饰的调用范围
 * @author: 董明林
 * @date: 2021-07-12 09:54:28
 */
public class teatA {

    protected void test(){
        System.out.println("aaaa");
    }

    public void test2(){
        System.out.println("2222");
    }
}