package atsingleton.type7;

public class SingletonTest7 {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println("sinleton1.hashcode=" + singleton1.hashCode());
        System.out.println("singleton2.hashcode=" + singleton2.hashCode());

    }
}
/*
* 1、这种方式采用了类装载的机制来保证初始化实例时只有一个线程
* 2、静态内部类方式在Singleton类被加载时并不会立即实例化，而是在需要实例化时，调用getinstance方法，
*    才会装载SingletonInstance类，从而完成Singleton的实例化
* 3、类的静态属性指挥在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程时无法进入的
* 4、优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
* */
class Singleton{
    private static volatile Singleton instance;
    //构造器私有化
    private Singleton(){

    }
    //写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    //提供一个静态的共有方法
    public static synchronized  Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
