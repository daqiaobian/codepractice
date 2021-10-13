package priority;

public class Test02 {
    public static void main(String[] args) {
        //创建最小优先队列对象
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(20);
        //存数据
        queue.insert("g");
        queue.insert("a");
        queue.insert("f");
        queue.insert("b");
        queue.insert("v");
        queue.insert("z");
        queue.insert("t");

        while (!queue.isEmpty()){
            String min = queue.delMin();
            System.out.print(min + " ");
        }
    }
}
