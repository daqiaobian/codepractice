package observer.improve;

public class CurrentConditions implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    public void display(){
        System.out.println("***Today mTemperature:"+temperature + "***");
        System.out.println("***Today mPressure:"+ pressure + "***");
        System.out.println("***Today mHumidity:"+ humidity + "***");
    }

    @Override
    public void update(float temperatrue, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
