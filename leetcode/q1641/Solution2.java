package demo.leetcode.q1641;

public class Solution2 {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;// C(n + 4, 4)
    }
}
