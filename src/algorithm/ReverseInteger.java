package src.algorithm;

/**
 * @author zjn
 * @date 2022/07/07
 **/
public class ReverseInteger {
    public static int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE) {
            return (int)r;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-110));
    }
}

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */