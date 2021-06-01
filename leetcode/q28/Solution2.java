package demo.leetcode.q28;

public class Solution2 {

    /**
     * kmp
     */
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int targetLen = needle.length();
        if (targetLen == 0)
            return 0;
        int[] next = getNext(needle);

        for (int i = 0, j = 0; i < len; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j - 1];

            if (haystack.charAt(i) == needle.charAt(j))
                j++;

            if (j == targetLen)
                return i - targetLen + 1;
        }
        return -1;
    }

    public int[] getNext(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];

        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = next[j - 1];

            if (pattern.charAt(i) == pattern.charAt(j))
                j++;

            next[i] = j;
        }

        return next;
    }

}
