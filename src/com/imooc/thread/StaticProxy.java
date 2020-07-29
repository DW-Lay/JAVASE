package com.imooc.thread;

/**
 * @author Lincoln
 * @classname StaticProxy
 * @description 练习静态代理模式
 * @params TODO
 * @return
 * @date 2020/7/12 23:27
 */

/**
 * 静态代理总结：
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 */
//使用静态代理的好处：
    //代理对象可以做很多真实对象做不了的事情
    //真实对象专注于自己的事情
public class StaticProxy {
    public static void main(String[] args) {
//        You you  =new You("小明");
//        WeddingCompany weddingCompany = new WeddingCompany(you);
//        weddingCompany.HappyMarry();
        new Thread(()-> System.out.println("我爱你")).start();  //理解多线程的静态代理模式

        new WeddingCompany(new You("小明")).HappyMarry();
    }


}

interface  Marry{
    void HappyMarry();
}

class You implements  Marry{
    String name;

    public You(String name) {
        this.name = name;
    }

    @Override
    public void HappyMarry() {
        System.out.println(this.name+"要结婚了，超开心");
    }
}

class WeddingCompany implements Marry{

    private Marry target;

    WeddingCompany(Marry marry) {
        this.target = marry;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后");
    }

    private void before() {
        System.out.println("结婚前");
    }
}