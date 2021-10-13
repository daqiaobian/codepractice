package factory.atfactory;

import java.util.Calendar;

public class Factory {
    public static void main(String[] args) {
        //getInstance 是 Calender静态方法
        Calendar cal = Calendar.getInstance();
        //注意月份下标从0开始，所以取月份要加1
        System.out.println("年"+cal.get(Calendar.YEAR));
        System.out.println("month"+(cal.get(Calendar.MONTH)) + 1);
        System.out.println("day"+cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("hours"+cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute"+cal.get(Calendar.MINUTE));
        System.out.println("second"+cal.get(Calendar.SECOND));
    }
/*
* 1、工厂模式的意义
*   将实例化对象的代码提取出来，放到一个类中统一管理和维护，达到和主项目的依赖关系的解耦。从而提高项目的扩展和维护性
* 2、三种工厂模式（简单工厂模式、抽象工厂模式、工厂方法模式）
* 3）设计模式的依赖抽象原则
*   a、创建对象实例时，不要直接new类，而是把这个new类的动作放在一个工厂的方法中，并返回。有的书上说，变量不要直接持有具体类的引用
*   b、不要让类继承具体类，而是继承抽象类或者是实现interface（接口）
*   c、不要覆盖基类中已经实现的方法
* */
}

