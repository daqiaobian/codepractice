public class TMain {
    public static void main(String[] args) {
        TestSingleton ts1 = TestSingleton.getInstance();
        ts1.setName("jkjk");
        TestSingleton ts2 = TestSingleton.getInstance();
        ts2.setName("6789");

        ts1.printInfo();
        ts2.printInfo();

        System.out.println(ts1.hashCode());
        System.out.println(ts2.hashCode());

        if (ts1 == ts2){
            System.out.println("创建的是同一个实例");
        }else{
            System.out.println("创建的不是同一个实例");
        }
    }
}
