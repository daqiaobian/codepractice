package factory.fatorymethod.pizzastore.order;

import factory.fatorymethod.pizzastore.pizza.BJCheesePizza;
import factory.fatorymethod.pizzastore.pizza.BJPepperPizza;
import factory.fatorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }else {
            System.out.println("订购失败~~");
        }
        return pizza;
    }
}
