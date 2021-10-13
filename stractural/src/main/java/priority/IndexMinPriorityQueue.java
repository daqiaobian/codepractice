package priority;

public class IndexMinPriorityQueue <T extends Comparable<T>>{
    //用来存储元素的数组
    private T[] items;
    //保存每个元素在items数组中的索引。pq数组需要堆有序
    private int[] pq;
    //保存pq数组的逆序，pq的值作为索引,pq的索引作为值
    private int[] qp;
    private int N;

    public IndexMinPriorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        N = 0;
        for (int i = 0; i < qp.length; i++){
            //默认情况下，qp逆序不保存任何索引
            qp[i] = -1;
        }
    }
    //获取队列中元素的个数、
    public int size(){
        return N;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }
    //判断堆中索引i处的元素是否小于索引索引j处的元素
    private boolean less(int i, int j){
        //先通过pq找出items中的索引，然后在找出items中的元素进行比较
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }
    //交换堆中i索引和j索引处的值、
    private void exch(int i, int j){
        //先交换pq数组中的值
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        //更新qp数组中的值
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    //判断k对应的元素是否存在
    public boolean contains(int k){
        //默认情况下，qp的所有元素都为-1，如果某个位置插入了数据，则不为-1
        return qp[k] != -1;
    }
    //最小元素关联索引
    public int minIndex(){
        //pq的索引1处，存放的是最小元素在itens中的索引
        return pq[1];
    }
    //往队列中插入一个元素，并关联索引i
    public void insert(int i, T t){
        //如果索引i处已经存在了元素，则不让插入
        if (contains(i)){
            throw new RuntimeException("该索引已经存在");
        }
        //个数+1
        N++;
        //把该元素存放在items数组中
        items[i] = t;
        //使用pq存放i这个索引
        pq[N] = i;
        //在qp的i索引处存放N
        qp[i] = N;
        //上浮items[pq[N]]，让pq堆有序
        swim(N);
    }
    //删除最小的元素
    public int delMin(){
        //找到items中的最小元素的索引
        int minIndex = pq[1];
        //交换pq中索引1处的值和N处的值
        exch(1, N);
        //删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
        //删除pq中索引N处的值
        pq[N] = -1;
        //删除items中的最小元素
        items[minIndex] = null;
        //元素数量-1
        N--;
        //对pq[1]做下沉，让对有序
        sink(1);
        return minIndex;
    }
    //删除索引i关联的元素
    public void delete(int i){
        int k = qp[i];
        exch(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[i] = null;
        N--;
        sink(k);
        swim(k);
    }
    //把与索引i关联的元素修改为t
    public void changeItem(int i, T t){
        //修改items数组中索引i处的值为t
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }
    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while (k > 1){
            if (less(k, k/2)){
                exch(k, k/2);
            }
            k = k/2;
        }
    }
    //使用下沉算法，是索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        while (2*k <= N){
            int min = 2*k;
            if (2*k+1 <= N && less(2*k+1, 2*k)){
                min = 2*k+1;
            }
            //如果当前结点的值比子结点中的较小值小，则结束下沉
            if (less(k, min)){
                break;
            }
            exch(k,min);
            k = min;
        }
    }
}
