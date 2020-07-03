package demo.leetcode.q125;

import java.util.regex.Pattern;

/**
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 投鸡取窍（大道至简）
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = Pattern.compile("[^a-zA-Z0-9]").matcher(s).replaceAll("").trim().toLowerCase();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
        return sb.toString().equals(sb.reverse().toString());
    }

}
