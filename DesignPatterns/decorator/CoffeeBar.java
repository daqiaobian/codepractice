package decorator;

import decorator.mycoffee.LongBack;
import decorator.mydecorator.Chocolate;
import decorator.mydecorator.Milk;

public class CoffeeBar {
    public static void main(String[] args) {
        //装饰者模式下的订单： 2分巧克力+一份牛奶的Longblack

        Drink order = new LongBack();

        //加入一份牛奶
        order = new Milk(order);
        System.out.println(order.cost() + order.getDes());

        order = new Chocolate(order);
        System.out.println(order.cost() + order.getDes());

        order = new Chocolate(order);
        System.out.println(order.cost());
        System.out.println(order.getDes());
    }
}
