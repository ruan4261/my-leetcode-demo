package demo.leetcode.q1014;

/**
 * 1014. 最佳观光组合
 * <p>
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    public int maxScoreSightseeingPair(int[] A) {
        if (A.length == 1) return A[0];
        if (A.length == 2) return A[0] + A[1] - 1;
        int[] dp = new int[A.length];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            int nV = A[i];
            int pV = A[i - 1];
            int x = nV + pV - 1;
            int y = nV + A[dp[i - 1]] - i + dp[i - 1];
            if (x > ans || y > ans) ans = Math.max(x, y);
            if (x > y) dp[i] = i - 1;
            else dp[i] = dp[i - 1];
        }
        return ans;
    }

    public int maxScoreSightseeingPair2(int[] A) {
        int max = A[0];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }
        return ans;
    }

}
