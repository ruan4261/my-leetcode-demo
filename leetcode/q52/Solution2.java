package demo.leetcode.q52;

/**
 * 还是位运算叼
 */
public class Solution2 {

    // N
    private int num;
    // N皇后时，此变量bit尾部有N个1
    private int bitVerify;

    public int totalNQueens(int n) {
        this.num = n;
        this.bitVerify = (1 << n) - 1;
        return dfs(0, 0, 0, 0);
    }

    /**
     * 快速理解：从右上角开始摆放皇后，对行依次迭代
     * 每个皇后的下三个格子被封锁，其延展封锁线通过位移记录
     *
     * @param row 当前所在行下标
     * @param col 不允许摆放列（1代表不允许摆放）
     * @param pie 左斜下角不允许摆放（1代表不允许摆放）
     * @param na  右斜下角不允许摆放（1代表不允许摆放）
     * @return
     */
    private int dfs(int row, int col, int pie, int na) {
        if (row >= this.num) return 1;

        // bits记录可放置位，其标识为1
        int bits = (~(col | pie | na)) & this.bitVerify, sum = 0;
        // 从右往左查找bits中的1，其位置可放置皇后
        while (bits != 0) {
            // p的bit位只有一个1，其位置为bits的最后一个1
            int p = bits & -bits;
            // 下一行
            sum += dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            // 消除最后一个1
            bits = bits & (bits - 1);
        }

        return sum;
    }
}
