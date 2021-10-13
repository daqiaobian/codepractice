package openclose;

public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Tringle());
    }
}

class GraphicEditor{
    public void drawShape(Shape s){
        s.draw();
    }
}

abstract class Shape{
    int m_type;
    public abstract void draw();
}
class Rectangle extends Shape{

    Rectangle(){
        super.m_type = 1;
    }
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}
class Circle extends Shape{

    Circle(){
        super.m_type = 2;
    }
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Tringle extends Shape{

    Tringle(){
        super.m_type = 3;
    }
    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}

class OtherGraphi extends Shape{
    OtherGraphi(){
        super.m_type = 4;
    }
    @Override
    public void draw() {
        System.out.println("绘制其它图形");
    }
}
