package demo.leetcode.q1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> commonChars(String[] A) {
        final int[] record = new int[26];
        Arrays.fill(record, Integer.MAX_VALUE);

        for (String s : A) {
            final int[] currCount = new int[26];
            final int len = s.length();
            for (int i = 0; i < len; i++)
                currCount[s.charAt(i) - 'a']++;

            for (int i = 0; i < record.length; i++)
                record[i] = Math.min(record[i], currCount[i]);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            final int count = record[i];
            for (int j = 0; j < count; j++) {
                char ch = (char) ('a' + i);
                ans.add(String.valueOf(ch));
            }
        }
        return ans;
    }

}
