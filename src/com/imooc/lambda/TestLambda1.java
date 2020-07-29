package com.imooc.lambda;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author Lincoln
 * @classname TestLambda1
 * @description 推到lambda表达式
 * @params TODO
 * @return
 * @date 2020/7/14 15:12
 */
public class TestLambda1 {

    // 3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2!");
        }
    }



    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3!");
            }
        }

        like = new Like3();
        like.lambda();

        //5.匿名内部类 （没有类的名称，必须接口或者父类）
        like = new ILike(){
            @Override
            public  void lambda(){
                System.out.println("I like lambda4!");
            }
        };
        like.lambda();

        //6.用lambda简化   必须是函数式接口才能用
        like = ()->{
            System.out.println("I like lambda5!");
        };
        like.lambda();



    }
}

//1. 定义一个函数式接口  (即只有一个方法的接口）
interface  ILike{
    void lambda();
}
//2.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda!");
    }
}