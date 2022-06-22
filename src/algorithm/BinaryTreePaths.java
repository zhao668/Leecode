package src.algorithm;

import src.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 * @date 2022/6/22
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private static void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        //叶子节点
        if (root.left == null && root.right == null) {
            //输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            //回溯
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            //回溯
            paths.remove(paths.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(BinaryTreePaths.binaryTreePaths(TreeNode.createBinaryTree(new Integer[]{1, 2, 3, null ,5})));
    }
}

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */