package factory.fatorymethod.pizzastore.pizza;

public class LDCheesePizza extends Pizza{
    @Override
    public void parpare() {
        setName("伦敦奶酪pizza");
        System.out.println(" 给伦敦的奶酪披萨准备原材料。");
    }
}
