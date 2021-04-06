package demo.leetcode.q1638;

/**
 * 暴力1
 */
public class Solution {
    public int countSubstrings(String s, String t) {
        // 计算单个不同
        int ans = 0;
        int len = s.length();
        int tLen = t.length();

        for (int currentLen = 1; currentLen <= len; currentLen++) {
            int maxSize = len - currentLen;

            for (int i = 0; i <= maxSize; i++) {
                String base = s.substring(i, i + currentLen);

                int stop = tLen - currentLen;
                for (int j = 0; j <= stop; j++) {
                    if (helper(base, t.substring(j, j + currentLen))) ans++;
                }
            }
        }

        return ans;
    }

    /**
     * len(s1) == len(s2)
     */
    public boolean helper(String s1, String s2) {
        int len = s1.length();
        int diff = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
            if (diff > 1) return false;
        }

        return diff == 1;
    }
}
