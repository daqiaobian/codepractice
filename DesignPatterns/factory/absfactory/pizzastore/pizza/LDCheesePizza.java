package factory.absfactory.pizzastore.pizza;

import factory.absfactory.pizzastore.pizza.Pizza;

public class LDCheesePizza extends Pizza {
    public LDCheesePizza() {

    }
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println(" 给伦敦的奶酪披萨准备原材料。");
    }
}
