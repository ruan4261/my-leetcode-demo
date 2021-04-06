package demo.leetcode.q11;

public class Solution {

    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int wid = r - l;
            int hei;
            if (height[l] < height[r]) {
                hei = height[l];
                while (l < r && height[l] <= hei) l++;
            } else {
                hei = height[r];
                while (l < r && height[r] <= hei) l--;
            }

            ans = Math.max(ans, wid * hei);
        }

        return ans;
    }

}
