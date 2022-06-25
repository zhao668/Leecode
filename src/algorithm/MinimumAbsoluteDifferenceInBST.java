package src.algorithm;

import src.structure.TreeNode;

/**
 * @author zjn
 * @date 2022/6/25
 */
public class MinimumAbsoluteDifferenceInBST {
    /**
     * 记录上一个遍历的结点
     */
    static TreeNode pre;
    static int result = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    private static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }

    public static void main(String[] args) {
        System.out.println(MinimumAbsoluteDifferenceInBST.getMinimumDifference(TreeNode.createBinaryTree(new Integer[]{1,0,48,null,null,12,49})));
    }
}

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 */