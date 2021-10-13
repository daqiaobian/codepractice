package binarysearch;

public class BinarySearchNorECUR {
    public static void main(String[] args) {
        int[] arr = {1,2,6,9,65,88};
        int target = 9;
        int index =  binarySezrch(arr,target);
        System.out.println("index = " + index);
    }

    //二分查找分递归
    public static int binarySezrch(int[] arr, int target){
        int left = 0;
        int right = arr.length -1 ;
        while (left <= right){
            int mid = (left + right) /2;
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] > target){
                right = mid - 1;   //大于目标值往左边去找
            } else {
                left = mid + 1;
            }
        }
        return -1; //没找到返回-1
    }
}
