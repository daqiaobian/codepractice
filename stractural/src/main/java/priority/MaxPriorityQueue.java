package priority;

public class MaxPriorityQueue <T extends Comparable<T>>{
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public MaxPriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //删除堆中最大元素，并返回这个最大元素
    public T delMax(){
        T max = items[1];
        //交换索引1处和索引N处的值
        exch(1, N);
        //删除最后位置上的元素
        items[N] = null;
        N--; //个数-1
        sink(1);
        return max;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //如果已经到了根结点，就不需要循环了
        while (k > 1){
            //比较当前节点和其父节点
            if (less(k/2, k)){
                //父节点小于当前结点需要交换
                exch(k/2, k);
            }
            k = k/2;
        }
    }
    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //如果当前结点已经是最底层，就不需要循环
        while (2*k <= N){
            //找到子节点中较大者
            int max = 2 * k;
            if (2 * k +1 <= N){//存在右子节点
                if (less(2*k, 2*k+1)){
                    max = 2*k+1;
                }
            }

            //比较当前节点和子节点中较大者，如果当前节点不小，则结束循环
            if (!less(k, max)){
                break;
            }
            //当前结点小就交换
            exch(k, max);
            k = max;
        }
    }
}
