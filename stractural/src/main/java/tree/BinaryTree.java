package tree;


public class BinaryTree<Key extends Comparable<Key>, Value> { //使用泛型
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;

    //获取树中元素的个数
    public int size() {
        return N;
    }

    //向树中添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树x中添加key-value,并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
//个数+1
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
//新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = put(x.left, key, value);
        } else {
//新结点的key等于当前结点的key，把当前结点的value进行替换
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
            return get(x.right, key);
        } else if (cmp < 0) {
//如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            return get(x.left, key);
        } else {
//如果要查询的key等于当前结点的key，则树中返回当前结点的value。
            return x.value;
        }
    }

    //删除树中key对应的value
    public void delete(Key key) {
        root = delete(root, key);
    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
//新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {


//新结点的key等于当前结点的key,当前x就是要删除的结点
//1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            N--;
            if (x.right == null) {
                return x.left;
            }
//2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                return x.right;
            }
//3.当前结点的左右子树都存在
//3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
//3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
//3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点
            //minNode的右子树
            minNode.left = x.left;
            minNode.right = x.right;
//3.4让被删除结点的父节点指向最小结点minNode
            x = minNode;
//个数-1
        }
        return x;
    }

    //找出整个树中的最小键
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        //判断x有没有左子树结点，如果有，则继续往左找，如果没有，则x就是最小键所在的结点
        if (x.left != null){
            return min(x.left);
        }else {
            return x;
        }
    }

    //找出二叉树中的最大值、
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        //判断x有没有右子树结点，有，继续找，无则返回最大
        if (x.right != null){
            return max(x.right);
        }else{
            return x;
        }
    }

    //前序遍历
    public Key preErgodic(){
        Queue<Key> keys = new Queue<Key>();
        preErgodic(root, keys);
        return (Key) keys;
    }

    //遍历当前左子树的结点
    private void preErgodic(Node x, Queue<Key> keys){
        if (x == null) return;
        //把当前结点key放到队列中
        keys.enqueue(x.key);
        //找得到当前结点的左子树，非空即遍历
        if (x.left != null){
            preErgodic(x.left, keys);
        }else {
            preErgodic(x.right, keys);
        }
    }

    //使用中序遍历，获取整个树中的所有键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }
    //使用中序遍历，把指定树x中的所有键放入到keys队列中
    private void midErgodic(Node x, Queue<Key> keys){
        if (x == null) return ;
        //找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null){
            midErgodic(x.left, keys);
        }
        //把当前结点的key放到队列中；
        keys.enqueue(x.key);
        //找到当前节点的右子树，如果不为空，递归遍历右子树
        if (x.right != null){
            midErgodic(x.right, keys);
        }
    }

    //H后序遍历，获取整个书中的所有键
    public Queue<Key> afterErgodic(){
        return null;
    }
    //使用后序遍历，把指定树中x中的所有键放入keys队列中
    private void afterErgodic(Node x, Queue<Key> keys){
        if (x == null) return;
        if (x.left != null){
            afterErgodic(x.left, keys);
        }
        if (x.right != null){
            afterErgodic(x.right, keys);
        }
        keys.enqueue(x.key);
    }

    //使用层次遍历得到树中的所有键
    public Queue<Key> layerErgodic(){
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node x = nodes.dequeue();
            keys.enqueue(x.key);
            if (x.left != null){
                nodes.enqueue(x.left);
            }
            if (x.right != null){
                nodes.enqueue(x.right);
            }
        }
        return keys;
    }


    //计算整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    //计算指定树x的最大深度  (层次问题)
    private int maxDepth(Node x){
        //如果根节点为空，则最大深度为0
        if (x == null) return 0;
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        //计算左子树的最大深度
        if (x.left != null){
            maxL = maxDepth(x.left);
        }
        if (x.right != null){
            maxR = maxDepth(x.right);
        }
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
