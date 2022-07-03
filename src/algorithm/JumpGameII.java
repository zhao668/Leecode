package src.algorithm;

/**
 * 跳跃游戏（二）
 * @author zjn
 * @date 2022/07/03
 **/
public class JumpGameII {
    public int jump(int[] nums) {
        int result = 0;
        //当前覆盖的最远距离下标
        int end = 0;
        //下一步覆盖的最远距离下标
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; i++) {
            temp = Math.max(temp, i + nums[i]);
            //可达位置的改变次数就是跳跃次数
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }
}

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */