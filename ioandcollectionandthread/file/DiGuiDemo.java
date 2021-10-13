package file;

public class DiGuiDemo {
    /*public static void main(String[] args) {
        //求第二十个月兔子的对数
        //每个月的兔子对数：1，1，2，3，5，8.。。。
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[19]);
        System.out.println(f(20));
    }
    public static int f(int n){
        if (n == 1 || n == 2){
            return 1;
        }else{
            return f(n-1) + f(n-2);
        }*/
    public static void main(String[] args) {
        int result = jc(5);
        System.out.println(result);
    }
    public static int jc(int n){
        if (n == 1) return 1;
        else return n*jc(n-1);
    }

}
