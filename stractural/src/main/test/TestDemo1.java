import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo1 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "外层");
                    try{
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "中层");
                        try {
                            lock.lock();
                            System.out.println(Thread.currentThread().getName() + "内层");
                        } finally {
                            lock.unlock();
                        }

                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("aaaa");
                lock.unlock();
            }
        }, "aa").start();
     }
}
