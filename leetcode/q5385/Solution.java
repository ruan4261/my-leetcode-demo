package com.ruan.alg.leetcode.leetcode.q5385;

/**
 * leetcode contest question 5385 改变一个整数能得到的最大差值
 * <p>
 * 给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 * <p>
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 * <p>
 * 请你返回 a 和 b 的 最大差值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 * 示例 2：
 * <p>
 * 输入：num = 9
 * 输出：8
 * 解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 9 和 b = 1 ，最大差值为 8
 * 示例 3：
 * <p>
 * 输入：num = 123456
 * 输出：820000
 * 示例 4：
 * <p>
 * 输入：num = 10000
 * 输出：80000
 * 示例 5：
 * <p>
 * 输入：num = 9288
 * 输出：8700
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
class Solution {

    int maxDiff(int num) {
        char nine = Integer.toString(9).charAt(0);
        char zero = Integer.toString(0).charAt(0);
        char one = Integer.toString(1).charAt(0);
        boolean p = true;// 指示第一个数->默认取大
        String nStr1 = Integer.toString(num);
        String nStr2 = Integer.toString(num);

        // 操作数1
        for (int i = 0; i < nStr1.length(); ++i) {
            if (i == 0) {// 首位
                if (nStr1.charAt(i) == one) {
                    p = false;
                } else if (nStr1.charAt(i) != nine) {
                    nStr1 = nStr1.replace(nStr1.charAt(i), nine);
                    break;
                }
            } else {// 非首位
                if ((p && nStr1.charAt(i) != nine) || (!p && nStr1.charAt(i) != zero && nStr1.charAt(i) != one)) {
                    if (p) {
                        nStr1 = nStr1.replace(nStr1.charAt(i), nine);
                    } else {
                        nStr1 = nStr1.replace(nStr1.charAt(i), zero);
                    }
                    break;
                }
            }
        }

        // 操作数2
        if (p) {// 与第一个操作数反向
            nStr2 = nStr2.replace(nStr2.charAt(0), one);
        } else {
            nStr2 = nStr2.replace(nStr2.charAt(0), nine);
        }

        return p ? (Integer.parseInt(nStr1) - Integer.parseInt(nStr2)) : (Integer.parseInt(nStr2) - Integer.parseInt(nStr1));
    }
}