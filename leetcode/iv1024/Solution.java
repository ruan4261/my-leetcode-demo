package demo.leetcode.iv1024;

import java.util.Arrays;

public class Solution {

    public int videoStitching(int[][] clips, int T) {
        int[] record = new int[T];
        Arrays.fill(record, -1);

        for (int[] clip : clips) {
            if (clip[0] >= T) continue;
            record[clip[0]] = Math.max(record[clip[0]], clip[1]);
        }

        if (record[0] == -1) return -1;
        if (record[0] >= T) return 1;

        int idx = 0;
        int mostright = record[0];
        int nums = 0;
        for (; ; ) {
            int end = mostright;
            nums++;

            if (mostright >= T) return nums;

            for (; idx <= end; idx++)
                mostright = Math.max(mostright, record[idx]);

            if (end == mostright) break;
        }

        return -1;
    }

}
