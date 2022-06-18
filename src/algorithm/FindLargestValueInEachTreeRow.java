package src.algorithm;

import src.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zjn
 * @date 2022/6/18
 */
public class FindLargestValueInEachTreeRow {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmpNode = queue.poll();
                max = Math.max(max, tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindLargestValueInEachTreeRow.largestValues(TreeNode.createBinaryTree(new Integer[]{1, 3, 2, 5, 3, null, 9})));
    }
}

/**
 Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).



 Example 1:


 Input: root = [1,3,2,5,3,null,9]
 Output: [1,3,9]
 Example 2:

 Input: root = [1,2,3]
 Output: [1,3]


 Constraints:

 The number of nodes in the tree will be in the range [0, 104].
 -231 <= Node.val <= 231 - 1
 */
