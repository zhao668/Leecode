package src.algorithm;

import src.structure.TreeNode;

/**
 * 监控二叉树
 * @author zjn
 * @date 2022/07/06
 **/
public class BinaryTreeCameras {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (minCame(root) == 0) {
            res++;
        }
        return res;
    }

    /**
     * 节点的状态值
     * 0表示无覆盖
     * 1表示有摄像头
     * 2表示有覆盖
     * 后续遍历，根据左右节点的情况，来判读自己的状态
     * @param root
     * @return
     */
    private int minCame(TreeNode root) {
        if (root == null) {
            //空节点默认为有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);

        //如果左右节点都覆盖了的话，那么本节点的状态就应该是无覆盖，没有摄像头
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            return 2;
        }

    }
}

/**
 *You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * Example 2:
 *
 *
 * Input: root = [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val == 0
 */
