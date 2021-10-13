package decorator.mydecorator;

import decorator.Drink;

public class Soy extends Decorator{
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(2.5f);
    }
}
