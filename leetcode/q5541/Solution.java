package demo.leetcode.q5541;

public class Solution {
    public int countSubstrings(String s, String t) {
        // 计算单个不同
        int count = 0;
        int maxLen = s.length();
        int tMaxLen = t.length();
        for (int currentLen = 1; currentLen <= maxLen; currentLen++) {
            int maxSize = maxLen - currentLen;
            for (int i = 0; i <= maxSize; i++) {
                String base = s.substring(i, i + currentLen);

                int stop = tMaxLen - currentLen;
                for (int j = 0; j <= stop; j++) {
                    if (helper(base, t.substring(j, j + currentLen))) count++;
                }
            }
        }
        return count;
    }

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
