package demo.leetcode.lcp30;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    /**
     * 淦, int溢出导致比赛没过
     */
    public int magicTower(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0;
        long tail = 0;
        long hp = 1;
        for (int n : nums) {
            hp += n;
            if (n < 0) {
                priorityQueue.add(-n);
            }
            if (hp <= 0) {
                Integer i = priorityQueue.poll();
                if (i == null)
                    return -1;
                hp += i;
                tail += i;
                ans++;
            }
        }

        long finalHp = hp - tail;
        return finalHp <= 0 ? -1 : ans;
    }

}
