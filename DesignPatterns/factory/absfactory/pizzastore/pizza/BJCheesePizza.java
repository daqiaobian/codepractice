package factory.absfactory.pizzastore.pizza;

import factory.fatorymethod.pizzastore.pizza.Pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void parpare() {
        setName("背景奶酪pizza");
        System.out.println(" 给北京的奶酪披萨准备原材料。");
    }
}
