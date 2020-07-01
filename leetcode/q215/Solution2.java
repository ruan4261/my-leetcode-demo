package com.ruan.alg.leetcode.leetcode.q215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            }
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }

}
