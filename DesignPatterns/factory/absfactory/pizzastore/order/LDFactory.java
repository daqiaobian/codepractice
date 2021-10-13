package factory.absfactory.pizzastore.order;

import factory.absfactory.pizzastore.pizza.LDCheesePizza;
import factory.absfactory.pizzastore.pizza.LDPeppePizza;
import factory.absfactory.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory{
    Pizza pizza;
    @Override
    public Pizza createPizza(String orderType) {
        if (orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("pepper")){

        }
        return null;
    }
}
