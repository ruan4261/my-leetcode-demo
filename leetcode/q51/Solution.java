package com.ruan.alg.leetcode.leetcode.q51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 【自己找图吧......】
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 * <p>
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
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
    public List<List<String>> solveNQueens(int n) {
        init(n);
        solve(0);
        return this.ans;
    }

    // 每个解决方案作为一个子list，此子list的元素为每一行的打印信息
    private List<List<String>> ans;

    // 皇后数
    private int num;
    // 列安全标识
    private boolean[] colSafe;
    // 左上-右下对角线安全标识（ /// ）
    private boolean[] leftDiagonalSafe;
    // 右上-左下对角线安全标识（ \\\ ）
    private boolean[] rightDiagonalSafe;
    // 标记着每一行第几列(idx)放置着皇后
    private int[] currentCase;

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
        this.currentCase = new int[n];
        this.ans = new ArrayList<>();
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
                currentCase[row] = i;

                if (row < num - 1) {
                    this.solve(row + 1);
                } else {
                    this.log();
                }

                colSafe[i] = leftDiagonalSafe[row + i] = rightDiagonalSafe[(num - 1 - i) + row] = false;
            }
        }
    }

    /**
     * 将当前case作为一个解放入ans
     */
    private void log() {
        List<String> explain = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            char[] line = new char[num];
            Arrays.fill(line, '.');
            line[currentCase[i]] = 'Q';
            explain.add(String.valueOf(line));
        }
        this.ans.add(explain);
    }
}
