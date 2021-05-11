package com.imooc.thread;

/**
 * @author Lincoln
 * @classname TestThread1
 * @description 学习开启一个多线程方式一
 * @params TODO
 * @return
 * @date 2020/7/12 21:18
 */
public class TestThread1 extends Thread {

    //重写run方法，再调用start方法
    //线程不一定立即执行，CPU调度安排
    @Override
    public void run() {
        // run方法主线程
        for (int i = 0; i < 200; i++) {
            System.out.println("============我在看代码--"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        //调用start方法开启线程
        testThread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
