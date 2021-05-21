package com.imooc;

/**
 * @author Lincoln
 * @classname practice2
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2021/4/30 18:49
 */
public class practice2 {
    public static void main(String[] args) {
        practice2 prac = new practice2();
        System.out.println(prac.test());

    }
    public String test(){
        return Hello();
    }
    public String Hello(){
        System.out.println("test hello");
        return "hello";
    }
}
