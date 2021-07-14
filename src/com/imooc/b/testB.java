package com.imooc.b;

import com.imooc.a.teatA;

/**
 * @program: HelloWorld
 * @description: 调用a包里面的
 * @author: 董明林
 * @date: 2021-07-12 09:55:32
 */
public class testB extends teatA {

    public  void test3(){
        test2();
        test();
    }



    public static void main(String[] args) {
        new testB().test3();

    }
}