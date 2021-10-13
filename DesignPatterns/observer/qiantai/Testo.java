package observer.qiantai;

public class Testo {
    public static void main(String[] args) {
        //前台
        Secretary tongzijie = new Secretary();
        Boss hhs = new Boss();

        //看股票的
       StockObserver tonshi1 = new StockObserver("huahua", hhs);
       //看NBA的
        NBAObserver tonghsi2 = new NBAObserver("xixi" , hhs);

        //增加存储列表中
        hhs.Attch(tonshi1);
        hhs.Attch(tonghsi2);



        //action
        tongzijie.setAction("老板回来");

        hhs.setAction("我hhs来到");
        //通知
        tongzijie.Notify();

        hhs.Notify();


    }
}
