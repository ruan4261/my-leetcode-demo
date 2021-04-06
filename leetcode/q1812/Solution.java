package demo.leetcode.q1812;

public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '0' - 1;

        return ((x ^ y) & 1) == 1;
    }

}
