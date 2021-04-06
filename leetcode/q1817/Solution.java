package demo.leetcode.q1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> m = new HashMap<>();// key: uid; value: activity time
        int[] res = new int[k];
        for (int[] log : logs) {
            int uid = log[0];
            int time = log[1];

            Set<Integer> set = m.computeIfAbsent(uid, k1 -> new HashSet<>());
            set.add(time);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : m.entrySet()) {
            Set<Integer> set = entry.getValue();
            int size = set.size();
            if (size - 1 < k) {
                res[size - 1] += 1;
            }
        }
        return res;
    }

}
