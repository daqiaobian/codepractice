package xianxing;

public class SequenceList <T>{
    private T[] eles;
    private int N;
    public SequenceList(int capacity){
        eles = (T[])new Object[capacity];
        N =0;
    }

    public void clear(){
        N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int length(){
        return N;
    }
    public T get(int i){
        if (i < 0 || i  >= N){
            throw new RuntimeException("当前元素不存在");
        }
        return eles[i];
    }
    public void insert(T t){
        if (N == eles.length){
            throw new RuntimeException("当前表已满");
        }
        eles[N++] = t;
    }
    public void insert(int i, T t){
        if (i == eles.length){
            throw new RuntimeException("当前表已满");
        }
        if (i < 0 || i > N){
            throw new RuntimeException("插入的位置不合适");
        }
        for (int index=N; index > i; index--){
            eles[index] = eles[index-1];
        }
        eles[i] = t;
        N++;
    }
    public T remove(int i){
        if (i < 0 || i > N-1){
            throw new RuntimeException("当前要删除的元素不存在");
        }
        T result = eles[i];
        for (int index = i; index < N-1; index++){
            eles[index] = eles[index+1];
        }
        N--;
        return result;
    }
}
