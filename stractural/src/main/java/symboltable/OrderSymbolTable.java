package symboltable;

public class OrderSymbolTable <Key extends Comparable<Key>, Value>{
    private class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public OrderSymbolTable(){
        head = new Node(null,null,null);
        N = 0;
    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value){
        //记录当前节点
        Node curr = head.next;
        //记录上一个结点
        Node pre = head;
        //1、如果key大于当前节点key，则一致寻找下一个结点
        while(curr != null && key.compareTo(curr.key) > 0){
            pre = curr;
            curr = curr.next;
        }
        //2、如果当前结点的curr的Key和要插入的的key一样，则替换
        if (curr != null && curr.key.compareTo(key) == 0){
            curr.value = value;
            return;
        }
        //3、没有找到相同对的key，把新节点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        Node n = head;
        while (n.next != null){
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
        }
        n = n.next;
    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        Node n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
}
