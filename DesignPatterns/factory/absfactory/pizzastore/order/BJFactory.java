package factory.absfactory.pizzastore.order;

import factory.absfactory.pizzastore.pizza.BJCheesePizza;
import factory.absfactory.pizzastore.pizza.BJPepperPizza;
import factory.absfactory.pizzastore.pizza.Pizza;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")){

        }else if (orderType.equals("pepper")){

        }
        return pizza;
    }
}
