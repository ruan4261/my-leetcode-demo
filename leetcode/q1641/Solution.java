package demo.leetcode.q1641;

public class Solution {

    public int countVowelStrings(int n) {
        if (n == 0) return 0;
        int limit = n - 1;

        int a = 1, b = 1, c = 1, d = 1;
        for (int i = 0; i < limit; i++) {
            a += b + c + d + 1;
            b += c + d + 1;
            c += d + 1;
            d += 1;
        }

        return a + b + c + d + 1;
    }

}
