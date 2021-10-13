package ObjectClass;
/*
* 多态：同一个对象，在不同时刻表现出来的不同形态
* 多态的前提和体现
*   有继承/实现关系
*   有方法重写
*   有父类引用指向子类对象
* */
public class AnimalDemo {
    public static void main(String[] args) {
       /* Animal a = new Cat();
        System.out.println(a.age);  //多态编译看左，执行看左     成员变量
        a.eat();                    //编译看左，执行看右        成员方法*/

    /*    AnimalOperator ao = new AnimalOperator();
        Cat c = new Cat();
        ao.useAnimal(c);

        Dog d = new Dog();
        ao.useAnimal(d);*/

        AnimalOperator ao = new AnimalOperator();
        Animal a = new Cat();
        Animal b = new Dog();

        ao.useAnimal(a);
        ao.useAnimal(b);

    }
}
/*
* 因为成员方法有重写，而成员变量没有
* 1、多态的好处：提高了程序的扩展性
*    具体体现：定义方法的时候，使用父类型作为参数，将来在使用的时候，使用具体的子类型参与操作、
* 2、多态的弊端：不能使用子类的特有功能
* */
