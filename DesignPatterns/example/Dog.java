package example;

public class Dog extends Animal{
    public Dog(){};
    public Dog(int age, String name){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("狗吃骨头");
    }
}
