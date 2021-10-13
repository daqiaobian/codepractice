import java.util.*;
public class sanhua {
    public static void main(String[] args) {
        int arr[] = {2,3,5,7,1,4};
        banfa(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void banfa(int arr[]){
        int startvalue = 0,fastindex=0;
        for (int i = 1;i<=arr.length;i++){
            fastindex = i;
            startvalue = arr[i];
            while(fastindex-1>=0 && startvalue < arr[fastindex-1]){
                arr[fastindex] = arr[fastindex-1];
                fastindex--;
            }
            arr[fastindex] = startvalue;
        }
    }
}
