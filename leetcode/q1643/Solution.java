package demo.leetcode.q1643;

import java.util.Arrays;

public class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int hei = destination[0];// 实际高 - 1
        int wid = destination[1];// 实际宽 - 1
        char[] ans = new char[hei + wid];
        int[][] map = new int[wid + 1][hei + 1];

        // 标出每个点到目标点的可选路线数量
        Arrays.fill(map[wid], 1);
        for (int i = wid - 1; i >= 0; i--) {
            map[i][hei] = 1;
            for (int j = hei - 1; j >= 0; j--) {
                map[i][j] = map[i + 1][j] + map[i][j + 1];
            }
        }

        int idx = 0;
        int w = 0, h = 0;
        // 到边缘后停止循环，因为接下来的字符只可能有一种
        while (w < wid && h < hei) {
            int right = map[w + 1][h];
            if (k > right) {
                // 往下走
                ans[idx++] = 'V';
                h++;
                k -= right;
            } else {
                // 往右走
                ans[idx++] = 'H';
                w++;
            }
        }

        char ch = w == wid ? 'V' : 'H';
        while (idx < ans.length) ans[idx++] = ch;

        return String.valueOf(ans);
    }
}
