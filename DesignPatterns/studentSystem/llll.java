import java.util.*;
public class llll {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = "123 456 0";
        String[] strArray = s.split(" ");
        System.out.println(strArray);

        int[] arr = new int[strArray.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strArray[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< arr.length; i++){
            if (i == arr.length-1){
                sb.append(arr[i]);
            }else{
                sb.append(arr[i]).append(" ");
            }
        }
        String rew = sb.toString();
        System.out.println(rew);
    }
}