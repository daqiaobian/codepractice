package observer.improve;

import observer.conmon.CurrentConditions;

import java.util.ArrayList;

/*
 * 核心类
 *   1、包含最新的天气情况
 *   2、含有 观察者集合，使用ArrayList管理
 *   3、当数据有更新时就主动的调用ArrayList，通知哦所有的（接入方）就看到最新的消息
 * */
public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    //观察者集合
    private ArrayList<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void dataChange(){
        //currentConditions.update(getTemperature(),getPressure(),getHumidity());
        //调用notifyObservers
        notifyObservers();
    }

    //当数据由更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange，将最新的消息推送给接入方currentConditions
        dataChange();
    }

    //注册一个观察者
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    //移除一个观察者
    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)){
            observers.remove(o);
        }
    }

    //遍历所有的观察者，并通知
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).update(getTemperature(),getPressure(),getHumidity());
        }
    }
}
