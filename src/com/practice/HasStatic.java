package com.practice;

/**
 * @program: HelloWorld
 * @description: 测试static修饰能否直接用
 * @author: 董明林
 * @date: 2021-08-07 20:36:02
 */
public class HasStatic {
    private  static int x =100;

    public static void main(String[] args) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println("x="+x);
    }
}