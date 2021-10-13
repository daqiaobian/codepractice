package factory.fatorymethod.pizzastore.order;

import factory.fatorymethod.pizzastore.pizza.LDCheesePizza;
import factory.fatorymethod.pizzastore.pizza.LDPeppePizza;
import factory.fatorymethod.pizzastore.pizza.Pizza;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new LDPeppePizza();
        }else {
            System.out.println("订购失败~~~");
        }
        return pizza;
    }
}
