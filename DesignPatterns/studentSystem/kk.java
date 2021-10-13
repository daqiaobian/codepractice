package studentSystem;
import java.util.*;
import java.lang.*;
public class kk {
    public static void main(String[] args) {
        Comparable[] c = {1,2,3};
        Comparable[] d = {4,5,6};
        int l = 0,r = 5, m = 2;


    }
    public static void merge(Comparable[] c, Comparable[] d, int l, int m, int r){
        int i = l,j = m+1, k = 1;
        while((i<=m) && (j<=r)){
            if (c[i].compareTo(c[j]) <= 0){
                d[k++] = c[i++];
            }else{
                d[k++] = c [j++];
            }
        }
        if (i > m){
            for (int q = j; q <= r; q++){
                d[k++] = c[q];
            }
        }else{
            for (int q = i; q <= m; q++){
                d[k++] = c[q];
            }
        }
    }
}
