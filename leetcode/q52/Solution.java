package demo.leetcode.q52;

/**
 * 52. N皇后 II
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    /**
     * 头函数
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        init(n);
        solve(0);
        return this.ans;
    }

    // 皇后数
    private int num;
    // 列安全标识
    private boolean[] colSafe;
    // 左上-右下对角线安全标识（ /// ）
    private boolean[] leftDiagonalSafe;
    // 右上-左下对角线安全标识（ \\\ ）
    private boolean[] rightDiagonalSafe;
    // 解集
    private int ans;

    /**
     * 初始化
     *
     * @param n
     */
    private void init(int n) {
        this.num = n;
        this.colSafe = new boolean[n];
        this.leftDiagonalSafe = new boolean[(n << 1) - 1];
        this.rightDiagonalSafe = new boolean[(n << 1) - 1];
    }

    /**
     * 目前操作行
     *
     * @param row
     */
    private void solve(int row) {
        for (int i = 0; i < num; ++i) {
            if (!colSafe[i] && !leftDiagonalSafe[row + i] && !rightDiagonalSafe[(num - 1 - i) + row]) {
                // safe case
                colSafe[i] = leftDiagonalSafe[row + i] = rightDiagonalSafe[(num - 1 - i) + row] = true;

                if (row < num - 1) {
                    this.solve(row + 1);
                } else {
                    this.ans++;
                }

                colSafe[i] = leftDiagonalSafe[row + i] = rightDiagonalSafe[(num - 1 - i) + row] = false;
            }
        }
    }
}
