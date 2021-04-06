package demo.leetcode.q1817;

import java.util.*;

public class Solution2 {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int[] ans = new int[k];
        for (int i = 0; i < logs.length; i++) {
            int active = 1;
            while (i + 1 < logs.length && logs[i][0] == logs[i + 1][0]) {
                if (logs[i][1] != logs[i + 1][1])
                    active++;
                i++;
            }

            if (active - 1 < k)
                ans[active - 1] += 1;
        }
        return ans;
    }

}
