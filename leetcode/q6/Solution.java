package demo.leetcode.q6;

/**
 * 6. Z 字形变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * rule:
     * row min -> 0 += 2numRows - 2
     * row n -> | row min + n | row max + n - 2 |
     * row max -> numRows += 2numRows - 2
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
        char[] c = s.toCharArray();
        int len = c.length;
        int row = 0;
        int incr = (numRows << 1) - 2;
        while (row++ < numRows) {
            if (row == 1) {
                for (int i = 0; i < len; i += incr) ans.append(c[i]);
            } else if (row == numRows) {
                for (int i = numRows - 1; i < len; i += incr) ans.append(c[i]);
            } else {
                int incrA = ((numRows - row + 1) << 1) - 2;
                int incrB = (row << 1) - 2;
                int i = row - 1;
                while (i < len) {
                    ans.append(c[i]);

                    i += incrA;
                    if (i >= len) break;
                    ans.append(c[i]);

                    i += incrB;
                }
            }
        }
        return ans.toString();
    }

}
