package xianxing;

import java.util.Iterator;

public class SequenceList1 <T> implements Iterable<T> {
    private T[] eles;
    private int N;

    public SequenceList1(int capacity){
        eles = (T[])new Object[capacity];
        N = 0;
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
        if (i < 0 || i >= N){
            throw new RuntimeException("当前元素不存在");
        }
        return eles[i];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
