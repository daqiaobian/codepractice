package studentSystem;
import java.util.*;
public class bnm {
    public static void main(String[] args) {
        int arr[] = {5,2,7,8,3};
        ghj(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void ghj(int arr[]){
        int current = 0;
        int index = 0;
        for (int i = 1; i<=arr.length; i++){
            current = arr[i];
            index = i-1;
            while(index >=0 && arr[index] > current){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index] = current;
        }
    }
}
