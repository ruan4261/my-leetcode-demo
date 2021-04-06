package demo.leetcode.q39;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    private List<List<Integer>> ans;

    private int[] count;

    /**
     * 不存在重复，不存在0
     * 这写的是个啥玩意算法，具体我也回答不上来，应该可以算广义上的dfs+回溯，这道题貌似不具备无后效性，不好进行状态转移
     * 这个方案总之不慢，leetcode时间领先99.6%
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.count = new int[candidates.length];
        // 进入最底部方法栈，每个栈对应一个解集元素
        for (int i = 0; i < candidates.length; i++) {
            count[i]++;
            dfs(candidates, target, i, candidates[i]);
            count[i]--;
        }
        return this.ans;
    }

    /**
     * 栈深度为对应sum(count)
     *
     * @param candidates
     * @param target
     * @param idx
     * @param sum
     */
    public void dfs(int[] candidates, int target, int idx, int sum) {
        for (int i = idx; i < candidates.length; i++) {
            if (sum > target) return;
            else if (sum == target) {// 凑到一个解，回溯
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < count.length; k++) {
                    if (count[k] != 0) {
                        for (int l = count[k]; l > 0; l--) {
                            list.add(candidates[k]);
                        }
                    }
                }
                this.ans.add(list);
                return;
            }

            sum += candidates[i];
            count[i]++;
            dfs(candidates, target, i, sum);
            count[i]--;
            sum -= candidates[i];
        }
    }
}
