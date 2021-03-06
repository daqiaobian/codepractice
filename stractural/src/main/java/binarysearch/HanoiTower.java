package binarysearch;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(64,'A','B','C');
    }

    //汉罗塔的移动方法
    //使用分治算法
    public static void hanoiTower(int num, char a, char b, char c){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第一个盘从" + a +"->"+ c);
        } else {
            //如果有n > 2,总是看作两个盘，1、最下边的一个盘，2、上面的所有盘
            //1、先把最上面的所有盘A->B，移动过程会使用到c
            hanoiTower(num-1, a, c, b);
            //2、把最下面的盘A->C
            System.out.println("第"+num +"个盘从"+a+"->"+c);
            //3、把B塔所有盘从B-》C，移动过程使用a塔
            hanoiTower(num-1,b,a,c);
        }
    }
}
