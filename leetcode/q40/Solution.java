package demo.leetcode.q40;

import java.util.*;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 这道题一下换两个规则，都不符合单一变量了
 *
 * @author ruan4261
 */
public class Solution {
    private List<List<Integer>> ans;

    private boolean[] used;// 给定数组中元素被使用情况

    private int sign;// repeat标记下标

    private Integer[] repeatSign;// 要被跳过的值->各个位置标记的上一次循环

    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.used = new boolean[candidates.length];
        Arrays.sort(candidates);
        this.sign = 0;
        this.repeatSign = new Integer[candidates.length];
        dfs(candidates, target, 0, 0);
        return this.ans;
    }

    /**
     * 一个方法栈代表了多一个参与元素
     *
     * @param candidates
     * @param target
     * @param idx
     * @param sum
     */
    private void dfs(int[] candidates, int target, int idx, int sum) {
        for (int i = idx; i < candidates.length; i++) {
            //判重
            if (repeatSign[sign] != null && candidates[i] == repeatSign[sign]) continue;
            else repeatSign[sign] = candidates[i];

            boolean flag = false;
            used[i] = true;
            sum += candidates[i];

            if (sum > target) flag = true;// 超出，回溯
            else if (sum == target) {
                // 凑到了一个解
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < used.length; j++) {
                    if (used[j]) list.add(candidates[j]);
                }
                this.ans.add(list);
                flag = true;
            } else {
                // 增加使用的元素，继续入栈
                this.sign++;
                dfs(candidates, target, i + 1, sum);
                if (sign < repeatSign.length) repeatSign[sign] = null;
                this.sign--;
            }

            sum -= candidates[i];
            used[i] = false;
            if (flag) return;
        }
    }
}
