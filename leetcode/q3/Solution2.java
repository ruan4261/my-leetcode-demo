package demo.leetcode.q3;

import java.util.Arrays;

public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        char[] c = s.toCharArray();
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < c.length; i++) {
            int e = map[c[i]];
            if (e != -1 && e >= i - temp) {
                ans = Math.max(ans, temp);
                map[c[i]] = i;
                temp = i - e;
            } else {
                map[c[i]] = i;
                temp++;
            }
        }
        return Math.max(ans, temp);
    }

}
