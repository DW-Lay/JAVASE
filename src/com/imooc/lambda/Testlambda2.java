package com.imooc.lambda;

/**
 * @author Lincoln
 * @classname Testlambda2
 * @description 继续练习
 * @params TODO
 * @return
 * @date 2020/7/14 16:41
 */
public class Testlambda2 {
    public static void main(String[] args) {

        //使用lambda表达式
        ILove love = (int a)->{
            System.out.println("i love you # ->"+a);
        };
        love.love(2);

        // lambda简化1 参数类型
        love = (a)->{
            System.out.println("i love you ->"+a);
        };
        love.love(1);
        //lambda简化2 简化括号
        love = a -> {
            System.out.println("i love you ->"+a);
        };
        love.love(3);

        //简化3，简化花括号
        love = a-> System.out.println("i love you->"+a);

        love.love(521);
    }
// 总结：
    //lambda表达式只能有一行代码的情况下才能去掉花括号，否则必须用代码块包裹
    //前提必须是函数式接口
    //多个参数也可以去掉函数类型，要去掉就全去掉，必须加上括号

}
interface  ILove{
    void love(int a);
}
class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("i love you ->"+a);
    }
}
