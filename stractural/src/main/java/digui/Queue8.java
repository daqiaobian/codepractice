package digui;

import static sun.misc.Version.print;

public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,1,3};
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    //编写一个方法，放置第n个皇后
    //特别注意：check时每一次递归时，进入到check中都有，for (int i =0;i<max;i++)
    //因此会有回溯
    private void check(int n){
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++){
            //先把这个皇后n，放到该放的行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行array[n] = i,即将第n个皇后，放置在本行的后移的一个位置

        }
    }
    //查看当我们放置第n个皇后，就去检测该皇后是否和前面摆放的皇后冲突
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++){
            /*
            * 1、array[i] == array[n] 表示判断第n个皇后是否和前面n-1个皇后在同一列
            * 2、Math.abs(n-i) == Math.abs(array[n]-array[i]) 便是判断第n个皇后是否和第i皇后是否在同一斜线
            * 3、n=1 放置第2列 1 n=1 array[1] = 1
            * 判断是否在同一行，没有必要，n每次都在递增
            * */
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    public void print(){
        count++;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.println();
        System.out.printf("一共判断冲突的次数%d次", judgeCount);
    }
}
