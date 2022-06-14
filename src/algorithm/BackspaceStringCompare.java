package src.algorithm;

/**
 * @author zjn
 * @date 2022/6/14
 */
public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        return sb(s).equals(sb(t));
    }

    private static String sb(String str) {
        StringBuilder sbr = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sbr.append(c);
            } else if (sbr.length() > 0) {
                sbr.deleteCharAt(sbr.length() - 1);
            }
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(BackspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
    }
}

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 */