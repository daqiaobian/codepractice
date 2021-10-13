package priority;

import javax.lang.model.element.NestingKind;

public class Test3 {
    public static void main(String[] args) {
        String[] arr = {"G","G","A","D","S"};
        IndexMinPriorityQueue<String> indexMin = new IndexMinPriorityQueue<>(10);
        for (int i =0; i < arr.length; i++){
            indexMin.insert(i, arr[i]);
        }
        System.out.println(indexMin.size());

        System.out.println(indexMin.minIndex());

        indexMin.changeItem(0,"F");
        int minindex = -1;
        while (!indexMin.isEmpty()){
            minindex = indexMin.delMin();
            System.out.print(minindex+"<");
        }
    }
}
