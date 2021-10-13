package tree;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeNode {
    Set<Integer> s = new HashSet<>();

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public int getData(){
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
