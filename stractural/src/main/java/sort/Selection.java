package sort;

import java.util.Collections;

public class Selection {
    //对a中的元素进行排序
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length-2; i++){
            //假定本次遍历，最小值所在的索引是i
            int minIndex = i;
            for (int j = i+1; j < a.length; j++){
                if (greater(a[minIndex], a[j])){
                    minIndex = j;
                }
            }
            //交换i索引处和minIndex索引处的值
            exch(a, i, minIndex);
        }
    }
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)> 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
