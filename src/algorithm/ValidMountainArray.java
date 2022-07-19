package src.algorithm;

/**
 * 有效的山脉数组
 * @author zjn
 * @date 2022/07/19
 **/
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        //双指针
        int left = 0;
        int right = arr.length - 1;
        //注意防止指针越界
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left ++;
        }

        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }
}

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 *
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */
