package demo.leetcode.q378;

public class Solution2 {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len - 1][len - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * num += 统计每一列有多少数 <= mid
     *
     * @param matrix
     * @param k
     * @param mid
     * @return count(n < = mid) >= k
     */
    private boolean check(int[][] matrix, int k, int mid) {
        int len = matrix.length;
        int row = len - 1;
        int col = 0;
        int num = 0;
        while (row >= 0 && col < len) {
            if (matrix[row][col] <= mid) {
                num += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return num >= k;
    }

}
