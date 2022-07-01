package src.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 * @date 2022/7/1
 */
public class RestoreIPAddresses {
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        restoreIPAddressesHandler(s, 0, 0);
        return result;
    }

    /**
     * number表示stringBuilder中ip段的数量
     */
    private void restoreIPAddressesHandler(String s, int start, int number) {
        if (start == s.length() && number == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        if (start == s.length() || number == 4) {
            return;
        }
        for (int i = start; i < s.length() && i - start < 3 &&
                Integer.parseInt(s.substring(start, i + 1)) >= 0 &&
                Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            stringBuilder.append(s.substring(start, i + 1));
            if (number < 3) {
                stringBuilder.append(".");
            }
            number++;
            restoreIPAddressesHandler(s, i + 1, number);
            number--;
            stringBuilder.delete(start + number, i + number + 2);
        }
    }
}

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 */