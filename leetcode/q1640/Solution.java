package demo.leetcode.q1640;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 */
public class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> idxMapper = new HashMap<>(pieces.length, 1f);
        for (int i = 0; i < pieces.length; i++) idxMapper.put(pieces[i][0], i);

        for (int i = 0; i < arr.length; ) {
            int base = arr[i];
            Integer mapIdx = idxMapper.get(base);
            if (mapIdx == null) return false;
            int[] same = pieces[mapIdx];
            if (!this.isEquals(arr, i, same)) return false;
            i += same.length;
        }

        return true;
    }

    public boolean isEquals(int[] a1, int idx, int[] a2) {
        int i = 0;
        for (; idx < a1.length && i < a2.length; idx++, i++)
            if (a1[idx] != a2[i]) return false;
        return i == a2.length;
    }

}
