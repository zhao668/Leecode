package src.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @author zjn
 * @date 2022/07/01
 **/
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        premuteHelper(nums);
        return result;
    }

    private void premuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            premuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */