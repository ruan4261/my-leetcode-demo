package demo.leetcode.q7;

/**
 * 7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * it's so silly
     * 用long算作弊了
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        char[] chars = Integer.toString(x).toCharArray();
        if (chars.length == 1) return x;

        for (int i = 0; i < chars.length && i < chars.length - i; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        String str;
        boolean m = false;
        int i = 0;
        for (; i < chars.length; ) {
            if (chars[i] == '0') i++;
            else break;
        }
        if (chars[chars.length - 1] == '-') {
            m = true;
            str = String.valueOf(chars, i, chars.length - 1 - i);
        } else str = String.valueOf(chars, i, chars.length - i);

        long ans = Long.parseLong(str);
        if (!m && ans > Integer.MAX_VALUE) return 0;
        if (m && -ans < Integer.MIN_VALUE) return 0;

        return (int) (m ? -ans : ans);
    }

}
