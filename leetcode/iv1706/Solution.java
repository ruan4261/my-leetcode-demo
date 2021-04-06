package demo.leetcode.iv1706;

/**
 * 面试题 17.06. 2出现的次数
 * <p>
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>
 * 示例:
 * <p>
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * <p>
 * n <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public static void main(String[] args) {
    }

    /**
     * 数位dp从大到小走递归
     *
     * @param n
     * @return
     */
    public int numberOf2sInRange(int n) {
        if (n < 2) return 0;
        if (n < 12) return 1;

        // 申明
        int len = (int) Math.ceil(Math.log10(n));
        int comp = (int) Math.pow(10, len - 1);
        int firstNum = n / comp;
        int next = n % comp;

        int count = (comp / 10) * (len - 1) * firstNum;

        if (firstNum > 2) {
            count += (comp / 10) * 10;
        } else if (firstNum == 2) {
            count += next + 1;
        }
        count += this.numberOf2sInRange(next);

        return count;
    }

}
