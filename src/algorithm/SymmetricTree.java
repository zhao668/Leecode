package src.algorithm;

import src.structure.TreeNode;

/**
 * @author zjn
 * @date 2022/6/19
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        //比较外侧
        boolean compareOutside = compare(left.left, right.right);
        //比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public static void main(String[] args) {
        System.out.println(SymmetricTree.isSymmetric(TreeNode.createBinaryTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }
}

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */