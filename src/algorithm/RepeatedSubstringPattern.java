package src.algorithm;

/**
 * @author zjn
 * @date 2022/6/13
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if ("".equals(s)) {
            return false;
        }
        int len = s.length();
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        for (int i = 2, j = 0; i <= len; i++) {
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            next[i] = j;
        }

        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(RepeatedSubstringPattern.repeatedSubstringPattern("abab"));
    }
}

/**
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */