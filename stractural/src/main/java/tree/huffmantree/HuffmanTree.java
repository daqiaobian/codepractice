package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        //测试，前序遍历
        preOrder(root);
    }

    //编写前序遍历的方法发
    public static void preOrder(Node root){
        if (root != null){
            root.preorder();
        }else {
            System.out.println("该树空树不能遍历");
        }
    }

    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr){
        //为操作方便，
        //遍历arr数组，将arr的每个元素构建一个node，将node 放到ArrayList
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr){
            nodes.add(new Node(value));
        }

        //一直重复下面这个步骤
        while (nodes.size() > 1) {
            //排序 从小到大
            Collections.sort(nodes);
            System.out.println(nodes);

            //取出根结点权值最小的两颗二叉树
            //取出权值最小的结点
            Node leftNode = nodes.get(0);
            //取出第二小的
            Node rightNode = nodes.get(1);
            //构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //从arraylist中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将parent加入nodes；
            nodes.add(parent);
        }
        //返回赫夫曼树的结点
        return nodes.get(0);
    }

}

//为了让Node对象支持排序 Collections集合排序，让Node实现Cmparable接口
//创建结点类
class Node implements Comparable<Node>{
    int value; //结点权值
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    //前序遍历
    public void preorder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preorder();
        }
        if (this.right != null){
            this.right.preorder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.value - o.value;
    }
}
