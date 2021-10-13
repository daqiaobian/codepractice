package thread.runnable;

public class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunnable my = new MyRunnable();
        //创建Thread类的对象，把MyRunnable对象作为构造方法的参数
       /* Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);*/

        Thread t1 = new Thread(my,"高铁");
        Thread t2 = new Thread(my, "飞机");

        t1.start();
        t2.start();
    }
}
