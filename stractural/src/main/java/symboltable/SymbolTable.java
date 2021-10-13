package symboltable;
//符号表
public class SymbolTable <Key, Value>{
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

    public SymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }

    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value){
        //先从符号表中查找建为key的键值对
        Node n = head;
        while (n.next != null){
            n = n.next;
            if (n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        //符号表中没有键为key的键值对
        Node oldFirst = head.next;
        Node newFirst = new Node(key, value, oldFirst);

        head.next = newFirst;
        //个数+1
        N++;

    }
    //删除符号表中键为key的键值对
    public void delete(Key key){
        Node n = head;
        while (n.next != null){
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
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
