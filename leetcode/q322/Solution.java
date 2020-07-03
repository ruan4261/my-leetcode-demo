package demo.leetcode.q322;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
class Solution {

    int res = Integer.MAX_VALUE;

    /**
     * 执行方法 dfs 贪心 剪枝
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);// 排序
        dfs(coins, coins.length - 1, amount, 0);// index是从后往前
        return res == Integer.MAX_VALUE ? -1 : res;// 判断并输出结果
    }

    /**
     * 深度优先搜索
     * 单次贪心算法，具有无后效性，只考虑本次最优，不在乎全局amount值
     *
     * @param coins  硬币数组不变
     * @param index  选取的硬币数组下标，根据深度变小
     * @param amount 当前迭代的目标，无关全局amount
     * @param count  已使用多少硬币
     */
    public void dfs(int[] coins, int index, int amount, int count) {

        // 莫卓了
        if (index < 0) {
            return;
        }

        // 当前index对应硬币使用量n，不断减小
        for (int n = amount / coins[index]; n >= 0; n--) {
            // 除以当前硬币面值*用量，获得余，即下一次迭代时的目标amount
            int nextAmount = amount - n * coins[index];
            // 已用硬币量，一起送到下一次迭代
            int nextCount = count + n;

            if (nextAmount == 0) {// 获得一个结果，抛弃当前深度
                res = Math.min(res, nextCount);
                return;
            }
            if (nextCount + 1 >= res) {// 超过已知最优结果，抛弃
                return;
            }

            dfs(coins, index - 1, nextAmount, nextCount);// 深度+
        }
    }
}
