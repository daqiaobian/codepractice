package observer.conmon;

public class Client {
    public static void main(String[] args) {

        //创建接入方
        CurrentConditions conditions = new CurrentConditions();
        //创建WeatherData并将接入方currentconditions传递到WeatherData中
        WeatherData weatherData = new WeatherData(conditions);
        //更新天气情况
        weatherData.setData(20,150,40);

        //天气情况改变\
        System.out.println("+++天气发生变化+++");
        weatherData.setData(40,68,55);
    }
}

/*
* 问题分析
*   1、其他第三方接入气象站获取数据的问题
*   2、无法在运行时动态的添加第三方（新浪网站）
*   3、违反ocp原则
*
* 在WeatherData中，当增加一个第三方，都需要创建一个对应的第三方的公告板对象，并加入dataChange，不利于维护，也不是动态加入
* */