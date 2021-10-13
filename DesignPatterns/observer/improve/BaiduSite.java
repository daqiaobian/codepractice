package observer.improve;

public class BaiduSite implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    public void display(){
        System.out.println("百度网站");
        System.out.println("***百度气温 mTemperature:"+temperature + "***");
        System.out.println("***百度气压 mPressure:"+ pressure + "***");
        System.out.println("***百度湿度 mHumidity:"+ humidity + "***");
    }

    @Override
    public void update(float temperatrue, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
