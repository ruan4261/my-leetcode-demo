package demo.leetcode.q1813;

public class Solution {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        int len1 = arr1.length;
        int len2 = arr2.length;
        int minLen = Math.min(len1, len2);

        int leftMatch = 0;
        int rightMatch = 0;

        while (leftMatch < minLen && arr1[leftMatch].equals(arr2[leftMatch])) leftMatch++;
        while (rightMatch < minLen && arr1[len1 - rightMatch - 1].equals(arr2[len2 - rightMatch - 1])) rightMatch++;

        return leftMatch == minLen || rightMatch == minLen || leftMatch + rightMatch == minLen;
    }

}
