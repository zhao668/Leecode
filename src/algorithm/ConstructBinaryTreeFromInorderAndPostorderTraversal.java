package src.algorithm;

import src.structure.TreeNode;

/**
 * @author zjn
 * @date 2022/6/23
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private static TreeNode buildTree1(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        //没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        //只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        //后序数组postorder里最后一个即为根节点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        //根据根节点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        //根据rootIndex划分左右子树
        root.left = buildTree1(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */