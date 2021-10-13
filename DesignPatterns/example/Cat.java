package example;

public class Cat extends Animal{

    public Cat(){
    };

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void eat(){
        System.out.println("猫吃鱼");
    }
}

