package demo.leetcode.q125;

/**
 * 正经解法
 */
public class Solution2 {

    /**
     * 震裆的光，照在了大腚上
     * 
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int low = 'a' - 'A';
        int len = s.length();
        char[] chars = s.toCharArray();
        int i = 0, j = len - 1;
        while (i < j) {
            boolean pass = false;
            char c1 = chars[i];
            char c2 = chars[j];
            if (c1 < '0' || c1 > 'z' || (c1 > '9' && c1 < 'A') || (c1 > 'Z' && c1 < 'a')) {
                i++;
                pass = true;
            }
            if (c2 < '0' || c2 > 'z' || (c2 > '9' && c2 < 'A') || (c2 > 'Z' && c2 < 'a')) {
                j--;
                pass = true;
            }
            if (pass) continue;
            if (c1 >= 'a') c1 -= low;
            if (c2 >= 'a') c2 -= low;
            if (c1 != c2) return false;
            i++;
            j--;
        }
        return true;
    }

}
