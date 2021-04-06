package demo.leetcode.q1642;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 小根堆
 */
public class Solution2 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> queue = new PriorityQueue<>();
        int sum = 0;// 使用的砖块数

        int limit = heights.length - 1;
        int i = 0;
        for (; i < limit; i++) {
            int gap = heights[i + 1] - heights[i];
            if (gap > 0) {
                queue.offer(gap);
                if (queue.size() > ladders) sum += queue.poll();
                if (sum > bricks) break;
            }
        }

        return i;
    }

}
