package com.imooc.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lincoln
 * @classname R
 * @description 类的描述
 * @params TODO
 * @return
 * @date 2021/4/17 19:38
 */
public class TestThread5 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition printNum = lock.newCondition();
    private static Condition printChar = lock.newCondition();
    public static void main(String[] args) {

        new Thread(new printNum()).start();
        new Thread(new printChar()).start();

    }

    static class printNum implements Runnable {
        @Override
        public void run() {
            for(int i=1;i<=52;i++) {
                lock.lock();
                try {
                    printChar.signalAll();
                    System.out.print(i);
                    if(i%2==0){
                        printNum.await();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }

        }
    }
    static class printChar implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<26;i++){
                lock.lock();
                try {
                    printNum.signalAll();
                    System.out.print((char)(i+'A'));
                    printChar.await();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}

