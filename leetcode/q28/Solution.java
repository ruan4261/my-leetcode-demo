package demo.leetcode.q28;

public class Solution {

    /**
     * 暴力
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int start = 0;
        int compute = 0;
        int len = haystack.length();
        for (int i = 0; i < len; i++) {
            if (haystack.charAt(i) == needle.charAt(compute)) {
                if (compute == 0)
                    start = i;
                if (++compute == needle.length())
                    return i - needle.length() + 1;
            } else {
                if (compute != 0) {
                    i = start;
                    compute = 0;
                }
            }
        }
        return -1;
    }

}
