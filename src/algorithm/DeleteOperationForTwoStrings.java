package src.algorithm;

/**
 * 两个字符串的删除操作
 * @author zjn
 * @date 2022/07/16
 **/
public class DeleteOperationForTwoStrings {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }
}

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Example 2:
 *
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 */