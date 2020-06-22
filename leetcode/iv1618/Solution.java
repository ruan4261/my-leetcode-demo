package com.ruan.alg.leetcode.leetcode.iv1618;

/**
 * 面试题 16.18. 模式匹配
 * <p>
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 * <p>
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 真能绕...
     */
    public boolean patternMatching(String pattern, String value) {
        int len = value.length();
        char[] p = pattern.toCharArray();
        // a,b count
        int count_a = 0, count_b = 0;
        int signOffset = 0;
        for (int i = 0, l = p.length; i < l; i++) {
            if (p[i] == 'a') count_a = count_a + 1;
            else count_b = count_b + 1;
            if (signOffset == 0 && i > 0 && p[i] != p[i - 1]) signOffset = i;
        }

        // empty with pattern or value
        if (count_a == 0 && count_b == 0) return value.isEmpty();
        if (value.isEmpty()) return count_a == 0 || count_b == 0;
        // has a symbol is the value body
        if (count_a == 1 || count_b == 1) return true;
        // pattern only has single symbol
        if (count_a == 0 || count_b == 0) {
            int count = count_a + count_b;
            int q = len / count;
            int m = len % count;
            if (m != 0) return false;
            String repeat = value.substring(0, q);
            for (int i = 0; i < len; i++) {
                int idx = len % q;
                if (value.charAt(i) != repeat.charAt(idx)) return false;
            }
            return true;
        }

        // assert count_a > count_b
        boolean turn = false;
        if (count_b > count_a) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            turn = true;
        }

        // simple case : enum
        outer:
        for (int i = 0; i < len; i++) {
            int rest = len - (i * count_a);
            if (rest < 0) break;
            if (rest % count_b != 0) continue;
            int len_b = rest / count_b;

            // has a result, check the result
            String a;
            String b;
            if (turn && p[0] == 'b') {
                int offset = i * signOffset;
                b = value.substring(0, i);
                a = value.substring(offset, offset + len_b);
            } else if (turn && p[0] == 'a') {
                int offset = len_b * signOffset;
                a = value.substring(0, len_b);
                b = value.substring(offset, offset + i);
            } else if (!turn && p[0] == 'b') {
                int offset = len_b * signOffset;
                b = value.substring(0, len_b);
                a = value.substring(offset, offset + i);
            } else {// !turn && p[0] == 'a'
                int offset = i * signOffset;
                a = value.substring(0, i);
                b = value.substring(offset, offset + len_b);
            }
            // assert a != b
            if (a.equals(b)) continue;

            int len_a = a.length();
            len_b = b.length();

            // counter
            int c_a = 0, c_b = 0;
            for (char c : p) {
                int off = (c_a * len_a) + (c_b * len_b);
                if (c == 'a') {
                    String v = value.substring(off, off + len_a);
                    if (!a.equals(v)) continue outer;
                    c_a = c_a + 1;
                } else {
                    String v = value.substring(off, off + len_b);
                    if (!b.equals(v)) continue outer;
                    c_b = c_b + 1;
                }
            }

            // through
            return true;
        }
        return false;
    }

}
