package thread.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable{

    private int tickets = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                if (tickets > 0){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张锁");
                    tickets--;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    /*{
        private static int tickets = 100;
        private int x = 0;

        private Object obj = new Object();

        @Override
        public void run () {
//        //相同的票出现了多次
//        while (true) {
//            //ticket = 100
//            //t1,t2,t3
//            //假设t1线程强盗CPU的执行权
//            if (tickets > 0) {
//                try {
//                    Thread.sleep(100);
//                    //t1线程休息100
//                    //t2线程强盗了CPU的执行权，t2线程级开始执行，执行到这里的时候t2也休息100
//                    //t3强盗执行全，t3就开始执行，执行到这里也要休息100毫秒
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
//                tickets--;
//            }
//        }
//        while (true){
//            if (tickets > 0){
//                try {
//                    Thread.sleep(100);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "正在出售第" +tickets+ "张票");
//                tickets--;
        *//*while (true){
            synchronized (obj) {
                if (tickets > 0){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" +tickets+ "张票");
                    tickets--;
                }
            }
        }*//*

        while (true) {
            sellTicket();
        }
    }
        public static synchronized void sellTicket () {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
            tickets--;
        }
    }
    }*/
}
