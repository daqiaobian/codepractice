package observer.improve;

public class Client {
    public static void main(String[] args) {
        //创建一个WeatherData
        WeatherData weatherData = new WeatherData();

        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baidu = new BaiduSite();

        //注册weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baidu);

        weatherData.removeObserver(currentConditions);

        //测试
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(10f, 100f, 30.32f);
    }
}

/*
* 1、观察者模式设计后，会以集合的方式来管理用户（Observer），包括注册，移除和通知。
* 2、这样增加观察者（这里可以理解成一个新的公告板），就不需要去修改核心类WeatherData，不会修改代码，遵守了ocp原则
* */