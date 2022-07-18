package src.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 下一个更大元素II
 * @author zjn
 * @date 2022/07/18
 **/
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        //边界判断
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        //存放结果
        int[] result = new int[size];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * size; i++) {
            while (!st.isEmpty() && nums[i % size] > nums[st.peek()]) {
                result[st.peek()] = nums[i % size];
                st.pop();
            }
            st.push(i % size);
        }
        return result;
    }
}

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */