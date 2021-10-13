package heap;

import java.awt.*;
import java.util.Arrays;

public class HeapSort {
    //判断heap堆中索引处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    //交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap, int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //根据原数组source，构造处堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //1、把source中的元素拷贝到heap中，heap中的元素就形成一个无序的堆
        System.arraycopy(source,0,heap,1,source.length);
        // 对堆中的元素做下沉调整（从长度的一半处开始，往索引1处扫描）
        for (int i = (heap.length) / 2; i > 0; i--){
            sink(heap, i, heap.length-1);
            System.out.println(Arrays.toString(heap));
        }
    }

    //对source数组中的数据从小到大排序
    public static void sort(Comparable[] source){
        //1、创建一个比原始数组大1的数组
        Comparable[] heap = new Comparable[source.length+1];
        //2、构造堆
        createHeap(source, heap);
        //3、堆排序
        //3.1、定义一个变量，记录heap中未排序的所有元素中最大的索引
        int N = heap.length-1;

        while (N != 1) {
            //通过循环，交换1索引元素与N元素
            exch(heap, 1, N);
            N--;
            //排除交换后最大元素所在的索引，让它不要参与到堆的下沉调整

            //需要对索引1处的元素进行堆的下沉调整
            sink(heap, 1, N);
        }
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    //在heap堆中，对target处的元素做下沉，范围是0-range
    private static void sink(Comparable[] heap, int target, int range){
        while (2 * target <= range){
            //找出target结点的两个子节点较大值
            int max = 2*target;
            if (2 * target + 1 <= range){
                //存在右子节点
                if (less(heap, 2*target, 2*target+1)){
                    max = 2*target+1;
                }
            }
            //比较当前结点的值和较大结点的值
            if (less(heap, target, max)){
                exch(heap,target,max);
            }
            target = max;
        }
    }


}
