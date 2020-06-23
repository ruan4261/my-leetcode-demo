package com.ruan.alg.leetcode.leetcode.q67;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder ans = new StringBuilder(a);
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '0') continue;
            int offset = b.length() - i;
            for (int j = ans.length() - offset; ; j--) {
                if (j < 0) {
                    ans.insert(0, '1');
                    break;
                } else if (ans.charAt(j) == '0') {
                    ans.setCharAt(j, '1');
                    break;
                } else {
                    ans.setCharAt(j, '0');
                }
            }
        }
        return ans.toString();
    }

}
