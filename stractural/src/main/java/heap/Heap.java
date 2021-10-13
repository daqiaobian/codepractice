package heap;

public class Heap<T extends Comparable<T>>{
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数；
    private  int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }
    //判断堆中索引i出的元素是否小于索引j处的元素
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;    //把0索引舍弃,
        swim(N);
    }

    //删除堆中最大的元素，并返回这个最大的元素
    public T delMax(){
        T max = items[1];

        //交换索引1处的元素和 最大索引处的元素，让完全二叉树中最右侧的元素变为临时根结点
        exch(1, N);
        //最大索引处的元素删除
        items[N] = null;
        //元素个数-1
        N--;
        //通过下沉调整堆。让堆重新有序
        sink(1);
        return max;
    }

    //使用上浮算法，是索引 K 处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //通过循环不断比较当前节点的值和父节点的值，如果发现父节点的值比当前节点值小，则交换位置
        while (k > 1){// 2/2=1
            //比较当前结点和其父节点
            if (less(k/2 , k)){
                exch(k/2, k);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //通过循环不断的对比当前k结点和其左子结点2k以及右子节点2k+1中较大值的大小.如果当前节点小，交换位置。
        while (2*k <= N){
            //获取当前节点的子节点中较大结点
            int max;//记录较大结点所在的索引
            if (2*k+1 <= N){
                if (less(2*k, 2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }
            //比较当前节点和较大结点的值
            if (!less(k, max)){
                break;
            }
            //交换k索引处的值和max的值
            exch(k, max);

            //变换k的值
            k = max;
        }

    }
}
