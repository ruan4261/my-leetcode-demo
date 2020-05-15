package com.ruan.alg.leetcode.leetcode.q560;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    /**
     * 使用dp计算出每个元素的前缀和并记录
     * 如果减去某个前缀和等于k（减去k等于某个前缀和），则此前缀和所在位置到当前位置之间的和恰好为k
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
