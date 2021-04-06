package demo.leetcode.q120;

import java.util.List;

public class Solution3 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int len = triangle.size();
        int[] record = new int[len];
        for (List<Integer> list : triangle) upDate(record, list);
        int result = record[0];
        for (int i = 1; i < len; i++) result = Math.min(result, record[i]);
        return result;
    }

    private void upDate(int[] record, List<Integer> row) {
        int temp1 = record[0], len = row.size();
        for (int i = 0; i < len; i++) {
            if (i == 0) record[i] += row.get(i);
            else if (i == len - 1) record[i] = temp1 + row.get(i);
            else {
                int temp2 = row.get(i) + Math.min(temp1, record[i]);
                temp1 = record[i];
                record[i] = temp2;
            }
        }
    }

}
