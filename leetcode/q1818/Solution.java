package demo.leetcode.q1818;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    final int MOD = (int) (1e9 + 7);

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long ans = 0;// 总差值
        int[][] arr = new int[nums1.length][];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            int m = nums2[i];
            int diff = Math.abs(n - m);
            arr[i] = new int[]{diff, m};

            ans += diff;
            ans %= MOD;
        }

        Arrays.sort(arr, (e1, e2) -> e2[0] - e1[0]);
        nums1 = removeRepeat(nums1);
        Arrays.sort(nums1);

        int maxImprove = 0;// 最多能减少的差值
        for (int[] innerArr : arr) {
            if (innerArr[0] <= maxImprove) break;

            int minimumDiff = findMinimumDiff(nums1, innerArr[1]);
            int improve = innerArr[0] - minimumDiff;
            maxImprove = Math.max(maxImprove, improve);
        }

        int ans0 = (int) ((ans - maxImprove) % MOD);
        return ans0 < 0 ? ans0 + MOD : ans0;
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
