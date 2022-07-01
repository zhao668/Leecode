package src.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归子序列
 * @author zjn
 * @date 2022/07/01
 **/
public class IncreasingSubsequences {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)
                    || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

/**
 * Given an integer array nums, return all the different possible increasing subsequences of the given array with at least two elements. You may return the answer in any order.
 *
 * The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Example 2:
 *
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */