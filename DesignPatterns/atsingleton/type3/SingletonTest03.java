package atsingleton.type3;
/*
* 1、起到了LazyLoading的效果。但是只能在单线程下使用
* 2、如果多线程下，一个线程进入了if(sinfleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句
*    ，这是便会禅城多个实例。所以在多线程环境下不可使用这种方式
* 3、结论：在实际开发中不使用这种方式。
* */
public class SingletonTest03 {
    public static void main(String[] args) {
        //测试
        System.out.println("懒汉式，线程不安全");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("instance1.hashCode="+s1.hashCode());
        System.out.println("instance2.hashCode="+s2.hashCode());
    }
}
class Singleton{
    private static Singleton instance;

    private Singleton(){

    }
    //提供一个静态的共有方法，当使用到该方法是，采取创建instance
    //即懒汉式
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
