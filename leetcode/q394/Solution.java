package demo.leetcode.q394;

/**
 * 394. 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 啥优化也没上这就100%了？？？
     * 就这？就这？...
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (!s.contains("[")) return s;
        char[] c = s.toCharArray();
        StringBuilder ans = new StringBuilder();

        int n = 0;
        int dl = 0;
        int begin = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                if (dl == 0) n = n * 10 + c[i] - '0';
            } else if (c[i] == '[') {
                dl = dl + 1;
                if (dl == 1) begin = i + 1;
            } else if (c[i] == ']') {
                dl = dl - 1;
                if (dl == 0) {
                    String t = s.substring(begin, i);
                    for (int j = 0; j < n; j++) {
                        ans.append(t);
                    }
                    n = 0;
                }
            } else {
                if (dl == 0) ans.append(c[i]);
            }
        }
        return decodeString(ans.toString());
    }

}
