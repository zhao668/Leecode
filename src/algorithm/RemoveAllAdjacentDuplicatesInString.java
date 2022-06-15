package src.algorithm;

/**
 * @author zjn
 * @date 2022/6/15
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
       /* //拿字符串作为栈
        StringBuffer res = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();*/
        //双指针
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            ch[slow] = ch[fast];
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(RemoveAllAdjacentDuplicatesInString.removeDuplicates("abbaca"));
    }
}

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */