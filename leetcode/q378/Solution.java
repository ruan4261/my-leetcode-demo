package com.ruan.alg.leetcode.leetcode.q378;

/**
 * 378. 有序矩阵中第K小的元素
 * <p>
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 *  
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * O(kn)
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        int len = matrix.length;
        int[] a = new int[len];
        int ans = 0;
        int row = 0;
        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (a[i] >= len || (i > 0 && a[i] == a[i - 1])) continue;
                if (matrix[i][a[i]] < min) {
                    min = matrix[i][a[i]];
                    row = i;
                }
            }
            ans = min;
            a[row]++;
        }
        return ans;
    }

}
