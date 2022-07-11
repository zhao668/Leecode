package src.algorithm;

/**
 * 分割等和子集
 * @author zjn
 * @date 2022/07/11
 **/
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //物品i的重量是nums[i],其价值也是nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
