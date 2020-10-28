package demo.leetcode.q763;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int len = S.length();
        int[] last = new int[26];

        for (int i = 0; i < len; i++)
            last[S.charAt(i) - 'a'] = i;

        int start = 0;
        int currentPartEnd = 0;
        for (int i = 0; i < len; i++) {
            currentPartEnd = Math.max(currentPartEnd, last[S.charAt(i) - 'a']);

            if (i == currentPartEnd) {
                ans.add(currentPartEnd - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }

}
