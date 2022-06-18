package src.structure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zjn
 * @date 2022/6/17
 * 用链表存储的二叉树节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createBinaryTree(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean isLeft = true;
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = deque.getLast();
            if (isLeft) {
                if (arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            } else {
                if (arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    deque.addFirst(node.right);
                }
                deque.removeLast();
                isLeft = true;
            }
        }
        return root;
    }
}
