package atsingleton.type;

/*
* 1、解决了线程不安全问题，
* 2、效率太低，每个线程想获得类的实例时候，执行getinstance()方法都要进行同步，而其实这个方法只执行一次实例化代码就够了，
*    后面的想获得该类实例，直接return就行了 。方法进行同步太低
*
* */
public class SingletonTest04 {
    public static void main(String[] args) {
        System.out.println("线程安全~~，懒汉式2");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println("instance1.hascode" + instance1.hashCode());
        System.out.println("instance2.hashcode:" + instance2.hashCode());
    }
}
//懒汉式（线程安全，同步方式）
class Singleton{
    public static Singleton instance;
    private Singleton(){    }
    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    //及懒汉式
    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
