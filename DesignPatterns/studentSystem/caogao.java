package studentSystem;

import java.util.*;
import java.lang.*;

public class caogao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p, mian;
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (c == Math.sqrt(b*b + a*a)){
            p = (a+b+c)/2;
            mian = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.println(String.format("%.1f",mian));
        }else{
            System.exit(0);
        }

    }
}
