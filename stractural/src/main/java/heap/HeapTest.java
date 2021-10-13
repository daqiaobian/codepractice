package heap;

import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        /*//创建堆对象
        Heap<String> heap = new Heap<>(10);

        //往堆中存入字符串数据】、
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("J");
        heap.insert("H");
        heap.insert("I");
        heap.insert("G");

        //通过循环从堆中删除数据
        String del;
        while ((del = heap.delMax()) != null){
            System.out.print(del);
        }*/

        //待排序数组
        String[] arr = {"w","s","j"};
        //通过HeapSort堆原始数组,进行排序
        HeapSort.sort(arr);
        //打印
        System.out.println(Arrays.toString(arr));

        String[] arr1 = {"8", "4",  "1", "3"};
        HeapSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
