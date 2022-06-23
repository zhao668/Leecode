package src.algorithm;

import src.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 * @date 2022/6/23
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    }

    private static void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null) {
            preorderdfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            preorderdfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(PathSumII.pathSum(TreeNode.createBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
    }
}

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */