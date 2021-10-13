package factory.simplefactory.pizzastore.order;

import factory.simplefactory.pizzastore.pizza.CheesePizza;
import factory.simplefactory.pizzastore.pizza.GreekPizza;
import factory.simplefactory.pizzastore.pizza.PepperPizze;
import factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    /*public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
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
            else{
                break;
            }

            //输出披萨制作的过程
            pizza.parpare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }*/

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory){
        String orderType = "";//用户输入的

        this.simpleFactory = simpleFactory; //设置简单工厂对象

        do {
            orderType = getType();
            pizza = this.simpleFactory.cretePizza(orderType);

            //输出pizza
            if (pizza != null){
                pizza.parpare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println(" 订购pizza失败");
                break;
            }
        }while (true);

    }

    //写一个方法，可以获取客户希望订购的披萨种类
    private String getType(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }
}
