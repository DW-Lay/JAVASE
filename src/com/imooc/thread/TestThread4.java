package com.imooc.thread;

/**
 * @author Lincoln
 * @classname TestThread4
 * @description 练习多个线程同时操作同一个对象
 * @params TODO
 * @return
 * @date 2020/7/12 22:31
 */
// 存在一个问题，在多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread4 implements  Runnable {

    //
    int num;
    static int sum = 1;
    static int now_num = 0;

    public TestThread4(int num) {
        this.num = num;
    }

    //    private  int ticketNums = 10;
    @Override
    public void run() {
        synchronized (TestThread4.class) {
            while(sum <75){
                if (num == now_num) {
                    System.out.println("num:"+num+"->>"+sum++);
                    switch (now_num) {
                        case (0):
                            now_num = 1;
                            break;
                        case (1):
                            now_num = 2;
                            break;
                        case (2):
                            now_num = 0;
                            break;
                    }
                    TestThread4.class.notifyAll();
                } else {
                    try {
                        TestThread4.class.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TestThread4(0)).start();
        new Thread(new TestThread4(1)).start();
        new Thread(new TestThread4(2)).start();
    }
}
//        while (true){
//            if (ticketNums<=0){
//                break;
//            }
//            // 模拟延时
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(Thread.currentThread().getName() +"-->拿到了第"+ticketNums-- +"张票");
//        }
//    }


//    public static void main(String[] args) {
//        TestThread4 ticket = new TestThread4();
//
//        new Thread(ticket,"小明").start();
//        new Thread(ticket,"老师").start();
//        new Thread(ticket,"黄牛党").start();
//
//    }
//}
