package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,9,35,2,35,345,2,36,6,89};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;//左下标
        int r = right; //右下标
        //pivot中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;  //临时变量，作为交换时使用
        //while循环的目的是让比pivot值小放到左边
        //比pivot值大放到右边
        while (l < r){
            //在pivot的左边一直找，找到大于等于pivot值，才推出
            while (arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot){
                r -= 1;
            }
            //如果l >= r 说明pivot的左右两边的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后，发现这个arr[l] == pivot值相等r--,前移
            if (arr[l] == pivot){
                r -= 1;
            }
            if (arr[r] == pivot){
                l += 1;
            }
        }
        if (l == r){
            l+= 1;
            r -= 1;
        }
        if (left < r){
            quickSort(arr, left, r);
        }
        if (right > l){
            quickSort(arr, l, right);
        }
    }
}
