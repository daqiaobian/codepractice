package treeimprove;


public class RedBlackTree <Key extends Comparable<Key>,Value>{
    private class Node<Key, Value>{
        public Node left;
        public Node right;
        public Key key;
        public Value value;
        public boolean color;

        public Node(Key key, Value value,Node left, Node right, boolean color) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;
    private int N;
    private static final boolean RED = true; //红链接
    private static final boolean BLACK = false; //黑链接

    //判断当前结点父指向是否为红色
    public boolean isRed(Node x){
        //空结点默认为红色连接
        if (x == null){
            return false;
        }
        return x.color == RED;
    }

    //左旋
    private Node rotateLeft(Node h){
        Node hRight = h.right; //当前结点的右子节点
        //右子节点的左子节点
        Node lhRight = hRight.left;
        //让当前结点h的右子结点的左子结点成为当前结点的右子结点
        h.right=lhRight;
        //让当前结点h称为右子节点的左子节点
        hRight.left = h;
        //让当前结点h的color编程右子结点的color
        hRight.color = h.color;
        //让当前结点h的color变为RED
        h.color = RED;
        //返回当前结点的右子结点
        return hRight;
    }

    //右旋
    private Node rotateRight(Node h){
        Node hLeft = h.left;
        Node rHleft = hLeft.right;
        h.left = rHleft;
        hLeft.right = h;
        hLeft.color = h.color;
        h.color = RED;
        return hLeft;
    }

    //颜色反转
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private void put(Key key, Value val){
        root = put(root, key, val);
        root.color = BLACK;
    }
    //指定树中，完成插入操作，并返回添加元素后新的树
    private Node put(Node h, Key key, Value val){
        if (h==null){
            N++;
            return new Node(key,val,null,null, RED);
        }
        //比较要插入的键和当前结点的键
        int cmp = key.compareTo((Key) h.key);
        if (cmp < 0){
            h.left = put(h.left, key, val);
        }else if (cmp > 0){
            h.right = put(h.right,key,val);
        } else {
            h.value = val;
        }

        if (isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        return h;
    }
     public Value get(Key key){
        return get(root, key);
     }
     public Value get(Node x, Key key){
        if (x == null){
            return null;
        }
        //比较当前结点的键和key
         int cmp = key.compareTo((Key) x.key);
        if (cmp < 0){
            return (Value) get(x.left, key);
        }else if (cmp > 0){
            return (Value) get(x.right, key);
        }else {
            return (Value) x.value;
        }
     }

     public int size(){
        return N;
     }
}
