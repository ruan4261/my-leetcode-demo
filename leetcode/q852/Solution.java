package demo.leetcode.q852;

public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return i - 1;
        }

        throw new IllegalArgumentException();
    }

}
