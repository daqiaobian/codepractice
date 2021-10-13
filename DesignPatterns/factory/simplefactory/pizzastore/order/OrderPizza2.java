package factory.simplefactory.pizzastore.order;

import factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza2 {
    //获取用户想要得到怎样的披萨没问题
    public String getType(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pazza 的种类:");
            String str = strin.readLine();
            return str;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }
    //构造器
    Pizza pizza = null;
    String orderType = "";
    public OrderPizza2(){
        do {
            orderType = getType();
            pizza = SimpleFactory.cretePizza2(orderType);
            //输出pizza
            if (pizza != null){
                pizza.parpare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购失败");
                break;
            }
        }while(true);
    }

}
