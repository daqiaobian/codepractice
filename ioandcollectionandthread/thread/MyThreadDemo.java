package thread;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        m1.setName("高铁");
        m2.setName("飞机");

        m1.start();
        m2.start();
        //返回对当前正在执行的线程对象的引用
        System.out.println(Thread.currentThread().getName());
    }
}
