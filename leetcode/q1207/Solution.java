package demo.leetcode.q1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mapper = new HashMap<>();
        for (int val : arr)
            mapper.put(val, mapper.getOrDefault(val, 0) + 1);

        java.util.Collection<Integer> coll = mapper.values();
        return new HashSet<>(coll).size() == coll.size();
    }

}
