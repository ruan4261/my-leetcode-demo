package demo.leetcode.q955;

import java.util.Arrays;

/**
 * 955. 删列造序 II
 * <p>
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有 A = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 A 为["bef", "vyz"]。
 * <p>
 * 假设，我们选择了一组删除索引 D，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（A[0] <= A[1] <= A[2] ... <= A[A.length - 1]）排列的，然后请你返回 D.length 的最小可能值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["ca","bb","ac"]
 * 输出：1
 * 解释：
 * 删除第一列后，A = ["a", "b", "c"]。
 * 现在 A 中元素是按字典排列的 (即，A[0] <= A[1] <= A[2])。
 * 我们至少需要进行 1 次删除，因为最初 A 不是按字典序排列的，所以答案是 1。
 * 示例 2：
 * <p>
 * 输入：["xc","yb","za"]
 * 输出：0
 * 解释：
 * A 的列已经是按字典序排列了，所以我们不需要删除任何东西。
 * 注意 A 的行不需要按字典序排列。
 * 也就是说，A[0][0] <= A[0][1] <= ... 不一定成立。
 * 示例 3：
 * <p>
 * 输入：["zyx","wvu","tsr"]
 * 输出：3
 * 解释：
 * 我们必须删掉每一列。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public int minDeletionSize(String[] A) {
        char[][] chars = new char[A.length][A[0].length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = A[i].toCharArray();
        }
        int[] lessAble = new int[chars.length];// 用来记录可以乱序的元素
        int ans = 0;

        outer:
        for (int i = 0; i < chars[0].length; i++) {// 循环字符串列
            boolean pass = true;
            int prev = chars[0][i];
            int[] copy = Arrays.copyOf(lessAble, lessAble.length);

            for (int j = 1; j < chars.length; j++) {// 循环元素
                int curr = chars[j][i];
                if (curr < prev) {
                    if (lessAble[j] != 1) {// 此列作废了
                        ans++;
                        lessAble = copy;// 将乱序设置回溯：切换为备份的lessAble
                        continue outer;
                    }
                    prev = curr;
                } else if (curr > prev) {// 比前面元素同列小
                    lessAble[j] = 1;// 后面的列可以乱序不用管了
                    prev = curr;
                } else {
                    if (lessAble[j] != 1) pass = false;// 相等且不允许乱序，必须深入下一列
                }
            }

            if (pass) return ans;// 一切顺利，直接返回结果
        }

        return ans;
    }

}
