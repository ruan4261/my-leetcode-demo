package demo.leetcode.q1819;

public class Solution {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = max(nums);
        boolean[] divs = new boolean[max + 1];
        for (int n : nums) {
            divs[n] = true;
        }

        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if (!divs[i]) {
                for (int last = 0, multi = i << 1; multi <= max; multi += i) {
                    if (!divs[multi]) continue;

                    last = gcd(multi, last);
                    if (last == i) {
                        ans++;
                        break;
                    }
                }
            } else ans++;
        }
        return ans;
    }

    public int max(int[] a) {
        int max = 0;
        for (int n : a) {
            max = Math.max(max, n);
        }
        return max;
    }

    @SuppressWarnings("all")
    int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}
