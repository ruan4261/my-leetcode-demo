package demo.leetcode.q14;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 深度优先
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        int next = 1;
        while (next < strs.length) {
            int maxLen = Math.min(ans.length(), strs[next].length());
            for (int i = 0; i < maxLen; i++) {
                if (ans.charAt(i) != strs[next].charAt(i)) maxLen = i;
            }
            ans = ans.substring(0, maxLen);
            next = next + 1;
        }
        return ans;
    }

    /**
     * 广度优先
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int idx = 0;
        outer:
        while (true) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (idx >= strs[i].length() || idx >= strs[i + 1].length() || strs[i].charAt(idx) != strs[i + 1].charAt(idx))
                    break outer;
            }
            idx = idx + 1;
        }
        return strs[0].substring(0, idx);
    }

    /**
     * 对比
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
