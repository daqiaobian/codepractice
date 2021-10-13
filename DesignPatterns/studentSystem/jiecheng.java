package studentSystem;

import java.util.Scanner;

public class jiecheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 1;
        for (int i = 1; i<=n;i++){
            //行数循环
            for (int j = 1; j<=n;j++){
                if (k<10){
                    System.out.print("0");
                    System.out.print(k);
                }else{
                    System.out.print(k);
                }
                k++;
            }
            System.out.println();
            n--;
        }
    }

}
