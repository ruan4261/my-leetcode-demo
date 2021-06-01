package demo.leetcode.q1744;

public class Solution {

    /**
     * @param queries 0: target; 1: day; 2: limited;
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] candies = incr(candiesCount);

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i][0];
            int day = queries[i][1];
            int limited = queries[i][2];

            long low = target == 0 ? 1L : candies[target - 1] + 1;// 目标区间head
            long high = candies[target];// 目标区间tail

            long eatLeast = day + 1;// 这一天最少会吃到第eatLeast颗
            long eatMost = (long) limited * (day + 1);// 这一天最多会吃到第eatMost颗

            ans[i] = eatLeast <= high && eatMost >= low;
        }
        return ans;
    }

    static long[] incr(int[] arr) {
        long[] res = new long[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = arr[i] + res[i - 1];
        }
        return res;
    }

}
