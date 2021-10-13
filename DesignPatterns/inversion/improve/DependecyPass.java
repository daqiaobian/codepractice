package inversion.improve;

public class DependecyPass {
    public static void main(String[] args) {
        ChangHong ch  = new ChangHong();
//        OpenAndClose op = new OpenAndClose();
//        op.open(ch);

        //通过构造器进行依赖
       /* OpenAndClose op = new OpenAndClose(ch);
        op.open();*/

        //通过serter方式进行依赖
        OpenAndClose op = new OpenAndClose();
        op.setTv(ch);
        op.open(); 
    }
}

////方式一：通过接口传递实现依赖
//interface IOpenAndClose{
//    public void open(ITV tv);
//}
//interface ITV{
//    public void play();
//}
class ChangHong implements ITV{

    @Override
    public void play() {
        System.out.println("长虹电视，打开");
    }
}
//class OpenAndClose implements IOpenAndClose{
//
//    @Override
//    public void open(ITV tv) {
//        tv.play();
//    }
//}

//方式二： 通过构造方法依赖传递
/*
interface IOpenAndClose{
    public void open();
}
interface ITV{
    public void play();
}
class OpenAndClose implements IOpenAndClose{
    public ITV tv;
    public OpenAndClose(ITV tv){
        this.tv = tv;
    }
    @Override
    public void open() {
        this.tv.play();
    }
}*/


//方式三 : 通过setter方式传递
interface IOpenAndClose{
    public void open();
    public void setTv(ITV tv);
}
interface ITV{
    public void play();
}
class OpenAndClose implements IOpenAndClose{

    private ITV tv;
    @Override
    public void open() {
        this.tv.play();
    }

    @Override
    public void setTv(ITV tv) {
        this.tv = tv;
    }
}