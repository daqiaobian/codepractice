package factory.absfactory.pizzastore.pizza;

import factory.fatorymethod.pizzastore.pizza.Pizza;

public class LDPeppePizza extends Pizza {
    @Override
    public void parpare() {
        setName("伦敦胡椒pizza");
        System.out.println(" 给伦敦的胡椒披萨准备原材料。");
    }
}
