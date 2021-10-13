package priority;

public class Test01 {
    public static void main(String[] args) {
        String[] arr = {"s","o","r","t","e"};
        MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
        for (String s : arr){
            maxpq.insert(s);
        }

        System.out.println(maxpq.size());
        String del;
        while (!maxpq.isEmpty()){
            del = maxpq.delMax();
            System.out.print(del + " ");
        }
    }
}
