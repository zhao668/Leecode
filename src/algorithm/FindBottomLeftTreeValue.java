package src.algorithm;

import src.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 * @date 2022/6/22
 */
public class FindBottomLeftTreeValue {
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindBottomLeftTreeValue.findBottomLeftValue(TreeNode.createBinaryTree(new Integer[]{2, 1, 3})));
    }
}

/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */