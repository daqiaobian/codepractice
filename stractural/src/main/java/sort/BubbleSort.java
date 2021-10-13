package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {1,5,9,2,3,4};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++){
            arr[i] = (int)(Math.random()*8000);
        }
        Date datal = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datelStr= simpleDateFormat.format(datal);
        System.out.println(datelStr);

        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean falg = false;
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-i; j++){
                if (arr[j] > arr[j+1]){
                    falg = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!falg){
                break;
            }else {
                falg = false;
            }
        }
    }

}
