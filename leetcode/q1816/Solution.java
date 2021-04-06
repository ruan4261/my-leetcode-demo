package demo.leetcode.q1816;

public class Solution {

    public String truncateSentence(String s, int k) {
        int len = s.length();
        int space = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (space++ == k - 1) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }

}
