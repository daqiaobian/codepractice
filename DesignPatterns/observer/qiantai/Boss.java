package observer.qiantai;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public void Attch(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer oo : observers){
            oo.update();
        }
    }
}
