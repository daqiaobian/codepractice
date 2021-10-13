package ObjectClass;


/*
* 多态 ，同一对象中不同的表现形式
* */
public class Cat extends Animal{

    public int age = 20;
    public int weight = 10;

    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void palyGame(){
        System.out.println("，毛捉迷藏");
    }
}
