package demo.leetcode.q1818;

import java.util.Arrays;
import java.util.HashSet;

public class Solution3 {

    final int MOD = (int) (1e9 + 7);

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] n = removeRepeat(nums1);
        Arrays.sort(n);

        int maxImprove = 0;
        long totalDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff;
            totalDiff %= MOD;
            maxImprove = Math.max(maxImprove, diff - findMinimumDiff(n, nums2[i]));
        }

        int ans = (int) ((totalDiff - maxImprove) % MOD);
        return ans < 0 ? ans + MOD : ans;
    }

    /**
     * 返回数组中与目标数最接近的元素与其的差值
     *
     * @param arr 已进行升序排序的数组
     */
    int findMinimumDiff(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = right - ((right - left) >> 1);
            if (mid == right) break;// right = left + 1
            else if (arr[mid] == target) return 0;
            else if (arr[mid] > target) right = mid;
            else left = mid;// arr[mid] < target
        }

        return Math.min(Math.abs(arr[left] - target), Math.abs(arr[right] - target));
    }

    /**
     * 去重, 不保证顺序
     */
    int[] removeRepeat(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int n : arr) {
            set.add(n);
        }
        int[] newArr = new int[set.size()];
        int i = 0;
        for (Integer n : set) {
            newArr[i++] = n;
        }
        return newArr;
    }

}
