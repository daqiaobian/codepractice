package atsingleton.type8;

public class SingletonTest08 {
}
class Singleton{
    private static   Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
