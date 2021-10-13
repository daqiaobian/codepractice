package observer.qiantai;

import java.util.ArrayList;
import java.util.List;

public class Secretary {
    //同事列表
    private List<StockObserver> observers = new ArrayList<StockObserver>();
    private String action;

    //增加    针对抽象编程，减少了与具体类的耦合
    public void Attch(StockObserver observer) {
        observers.add(observer);
    }

    //减少   针对抽象编程，减少了具体类的耦合
    public void Detach(Observer observer){
        observers.remove(observer);
    }

    //通知
    public void Notify(){
        for (StockObserver oo : observers){
            oo.update();
        }
    }

    //前台状态

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
