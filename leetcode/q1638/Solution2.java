package demo.leetcode.q1638;

/**
 * 暴力2
 * 大佬就是大佬，说好的暴力解，居然还带剪枝
 */
public class Solution2 {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int len1 = s.length();
        int len2 = t.length();

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int diff = 0;
                for (int k = 0; i + k < len1 && j + k < len2; k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) diff++;
                    if (diff == 1) ans += 1;
                    if (diff > 1) break;
                }
            }
        }

        return ans;
    }
}
