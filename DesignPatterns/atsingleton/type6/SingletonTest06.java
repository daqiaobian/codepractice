package atsingleton.type6;
/*
* Double-Check概念是多线程开发中常用到的，如代码所示，进行两次if，确保线程的安全
 * */
public class SingletonTest06 {
    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println("instance1.hascode" + instance1.hashCode());
        System.out.println("instance2.hashcode:" + instance2.hashCode());
    }
}
class Singleton{
    private static volatile Singleton instance;
    private Singleton(){};

    //提供一个静态的公有方法，加入双重检查代码解决线程安全问题，同时解决懒加载问题

    public static synchronized Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
/*
* 1、Double-Check概念是多线程开发中常用到的，进行两次if检查，保证线程安全
* 2、实例化代码只用执行一次，后面再次访问。判断if,直接return 实例化对象，也避免了反复进行方法同步
* 3、线程安全：延迟加载；效率较高
* */
