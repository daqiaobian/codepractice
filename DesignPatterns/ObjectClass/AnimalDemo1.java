package ObjectClass;
/*
* 向上转型
*       从子到父
*       父类引用指向子类对象
* 向下转型
*       从夫到子
*       父类引用转为子类对象
* */
public class AnimalDemo1 {
    public static void main(String[] args) {
        //多态
        Animal1 a1 = new Cat1(); //向上转型
        a1.eat();

       /* //创建cat类的对象
        Cat1 c = new Cat1();
        c.eat();
        c.palyGame();*/

        //向下转型
        Cat1 c = (Cat1)a1;
        c.palyGame();
        c.eat();
    }
}
