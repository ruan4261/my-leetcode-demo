package demo.leetcode.iv1001;

public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(B, 0, A, 0, n);
            return;
        }
        int idxA = m - 1;
        int idxB = n - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            boolean f = A[idxA] > B[idxB];
            if (f) {
                A[i] = A[idxA];
                idxA--;
            } else {
                A[i] = B[idxB];
                idxB--;
            }

            if (idxA == -1) {
                System.arraycopy(B, 0, A, 0, idxB + 1);
                return;
            } else if (idxB == -1) {
                System.arraycopy(A, 0, A, 0, idxA + 1);
                return;
            }
        }
    }

}
