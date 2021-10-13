package studentSystem;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class Main extends JFrame{
    public static void main(String[] args) {
        new Main().CreateJFrame("窗口");
    }
    public void CreateJFrame(String title){
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        JLabel jl = new JLabel("这是一个JFrame窗口");   //创建一个JLabel标签
        jl.setHorizontalAlignment(SwingConstants.CENTER);   //是标签上的文字居中

        container.add(jl);
        container.setBackground(Color.white);
        jf.setVisible(true);
        jf.setSize(200,150); //窗口大小的设计
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 设置窗口关闭方式
    }
}