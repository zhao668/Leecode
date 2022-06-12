package src.algorithm;

/**
 * @author zjn
 * @date 2022/6/12
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //定义一个哈希映射数组
        int[] record = new int[26];
        //遍历
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        //如果数组中存在负数，说明ransomNote字符串中存在magazine中没有的字符
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(RansomNote.canConstruct("aa", "aab"));
    }
}

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */