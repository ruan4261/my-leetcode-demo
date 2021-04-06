package demo.leetcode.offer64;

public class Solution {

    public int sumNums(int n) {
        boolean f = n > 0 && (n += sumNums(n - 1)) == -1;
        return n;
        //return ((int) (Math.pow(n, 2) + n)) >> 1;
    }

}
