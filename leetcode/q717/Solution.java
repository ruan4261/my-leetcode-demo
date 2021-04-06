package demo.leetcode.q717;

public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        final int len = bits.length;
        int series = 0;

        for (int i = len - 2; i >= 0; i--) {
            if (bits[i] == 0) break;
            series++;
        }

        return (series & 1) == 0;
    }

}
