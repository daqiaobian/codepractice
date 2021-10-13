package studentSystem;
import java.util.*;
import java.io.*;
public class ex1 {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = 0;
        for ( n=n; n!= 0; n /= 10){
            s = s*10 + n%10;
        }
        System.out.println(s);
    }
}
