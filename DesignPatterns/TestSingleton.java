public class TestSingleton {
    private String name = null;
    private TestSingleton(){}

    private static volatile TestSingleton instance = null;

    public static TestSingleton getInstance(){
        if (instance == null){
            synchronized (TestSingleton.class){
                if (instance == null){
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo(){
        System.out.println("the name is " + name);
    }
}
