package factory.simplefactory.pizzastore.order;

import factory.simplefactory.pizzastore.pizza.CheesePizza;
import factory.simplefactory.pizzastore.pizza.GreekPizza;
import factory.simplefactory.pizzastore.pizza.PepperPizze;
import factory.simplefactory.pizzastore.pizza.Pizza;

//简单工厂类
public class SimpleFactory {
    //根据orderType，返回对应的pizza 对象

    public Pizza cretePizza(String orderType){

        Pizza pizza = null;

        System.out.println("使用简单工厂模式" );
        if (orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }else if (orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }else if (orderType.equals("papper")){
            pizza = new PepperPizze();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }

    //简单工厂模式也叫静态工厂模式
    public static Pizza cretePizza2(String orderType){

        Pizza pizza = null;

        System.out.println("使用简单工厂模式" );
        if (orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }else if (orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }else if (orderType.equals("papper")){
            pizza = new PepperPizze();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
