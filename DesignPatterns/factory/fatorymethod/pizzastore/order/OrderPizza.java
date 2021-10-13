package factory.fatorymethod.pizzastore.order;

import factory.fatorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class OrderPizza {

    //定义一个抽象方法发，createPizza,让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    public OrderPizza(){
        Pizza pizza = null;
        String orderType; //订购pizza的类型
        do {
            orderType = getType();
            pizza = createPizza(orderType);//抽象方法由工厂子类完成
            //输出pizza制作过程
            pizza.parpare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }


    public String getType(){
        try{
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入想要pizza的种类：");
            String str = strin.readLine();
            return str;
        }catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
