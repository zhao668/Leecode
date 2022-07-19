package src.algorithm;

/**
 * 独一无二的出现次数
 * @author zjn
 * @date 2022/07/19
 **/
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2002];
        for (int j : arr) {
            count[j + 1000]++;
        }
        boolean[] flag = new boolean[1002];
        for (int i = 0; i <= 2000; i++) {
            if (count[i] > 0) {
                if (flag[count[i]] == false) {
                    flag[count[i]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
