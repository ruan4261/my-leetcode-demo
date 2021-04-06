package demo.leetcode.q1207;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) count++;
            else {
                if (!set.add(count)) return false;
                count = 1;
            }
        }

        return set.add(count);
    }

}
