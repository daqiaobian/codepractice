import java.util.HashMap;
import java.util.Map;

public class Singleton3 {
    private static Map<String, Singleton3> map = new HashMap<>();
    static {Singleton3 single = new Singleton3();
        map.put(single.getClass().getName(), single);
    }
    protected Singleton3(){ }
    //静态工厂方法，返回此类唯一的实例
    public static Singleton3 getInstance(String name){
        if (name == null){
            name = Singleton3.class.getName();
            System.out.println("name == null" + "----->name" + name);
        }
        if (map.get(name) == null){
            try{
                map.put(name, (Singleton3) Class.forName(name).newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
    public String about() {
        return "Hello, I am RegSingleton";
    }

    public static void main(String[] args) {
        Singleton3 single3 = Singleton3.getInstance(null);
        System.out.println(single3.about());
    }
}
