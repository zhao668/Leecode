package src.algorithm;

import src.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 * @date 2022/6/18
 */
public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth += 1;
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left == null && tmpNode.right == null) {
                    return depth;
                }
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                len--;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(MinimumDepthOfBinaryTree.minDepth(TreeNode.createBinaryTree(new Integer[]{3})));
    }
}

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */