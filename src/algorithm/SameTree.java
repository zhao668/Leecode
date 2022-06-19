package src.algorithm;

import src.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 * @date 2022/6/19
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.left);
            queue.offer(leftNode.right);
            queue.offer(rightNode.right);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(SameTree.isSameTree(TreeNode.createBinaryTree(new Integer[]{1, 2, 3}), TreeNode.createBinaryTree(new Integer[]{1, 2, 3})));
    }
}

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */