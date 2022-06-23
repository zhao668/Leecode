package src.algorithm;

import src.structure.TreeNode;

/**
 * @author zjn
 * @date 2022/6/23
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        int index = inLeft, val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        root.left = helper(preorder, preLeft + 1, preLeft + (index - inLeft),
                inorder,inLeft, index - 1);
        root.right = helper(preorder, preLeft + (index - inLeft) + 1, preRight,
                inorder, index + 1, inRight);
        return root;
    }
}

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */