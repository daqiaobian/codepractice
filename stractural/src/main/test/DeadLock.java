import java.util.concurrent.TimeUnit;

public class DeadLock {

    //创建两个对象
    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "  持有锁a,试图去获取锁b");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + " 获取锁b");
                    }
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "  持有锁b,试图去获取锁a");

                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + " 获取锁a");
                    }
                }
            }
        },"B").start();*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "  持有线程a，想要获取线程b" );
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + " 获取锁a");
                    }
                }
            }

        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "  持有线程b，想要获取线程a");

                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + " 获取线程a");
                    }
                }
            }
        },"B").start();
    }
}
