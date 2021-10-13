package observer.conmon;
/*
* 核心类
*   1、包含最新的天气情况
*   2、含有CurrentConditions对象
*   3、当数据有更新时就主动的调用CurrentConditions的update方法
* */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions){
        this.currentConditions = currentConditions;
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
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }

    //当数据由更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange，将最新的消息推送给接入方currentConditions
        dataChange();
    }
}
