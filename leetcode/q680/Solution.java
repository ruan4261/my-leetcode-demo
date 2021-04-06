package demo.leetcode.q680;

/**
 * 680. 验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        if (len < 3) return true;

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                boolean ks = false, ls = false;
                for (int k = i + 1, l = j; k < l; k++, l--) {
                    if (chars[k] != chars[l]) {
                        ks = true;
                        break;
                    }
                }
                if (!ks) return true;
                for (int k = i, l = j - 1; k < l; k++, l--) {
                    if (chars[k] != chars[l]) {
                        ls = true;
                        break;
                    }
                }
                return !ls;
            }
        }

        return true;
    }

}
