package src.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集问题（二）
 * @author zjn
 * @date 2022/07/01
 **/
public class SubsetsII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0);
        return res;
    }

    private void subsetsWithDupHelper(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            //跳过当前数层使用过的、相同的元素
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
        }
    }
}

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */