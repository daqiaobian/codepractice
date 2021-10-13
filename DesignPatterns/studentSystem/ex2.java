package studentSystem;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum, max = 0,day;
        for (int i =0; i<=7;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum = a+b;
            if ((sum > max) && (sum>8)){
                max = sum;
                day = i;
                System.out.println(day);
            }
        }

    }
}
