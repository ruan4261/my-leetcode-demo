package demo.leetcode.q5554;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        return this.helper(arr, pieces, 0, new HashSet<>());
    }

    public boolean helper(int[] arr, int[][] pieces, int arrIdx, Set<Integer> used) {
        if (arrIdx >= arr.length) return true;

        search:
        for (int idx = 0; idx < pieces.length; idx++) {
            if (used.contains(idx)) continue;
            int[] piece = pieces[idx];

            if (piece[0] == arr[arrIdx]) {
                int i = arrIdx;

                for (int k = 0; k < piece.length; k++, i++)
                    if (i >= arr.length || arr[i] != piece[k]) continue search;

                // 找到了一个
                used.add(idx);
                if (this.helper(arr, pieces, i, used)) return true;
                used.remove(idx);
            }
        }
        return false;
    }

}
