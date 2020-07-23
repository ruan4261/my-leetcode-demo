package demo.leetcode.q64;

/**
 * 利用行差倒序计算，这波是妙蛙种子吃着妙脆角进了妙妙屋
 * 但是同样时间量级为什么这能这么快？？？
 */
public class Solution2 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] mark = new int[col];
        mark[col - 1] = grid[row - 1][col - 1];

        for (int i = col - 2; i >= 0; i--)
            mark[i] = mark[i + 1] + grid[row - 1][i];

        helper(mark, grid, row - 2);
        return mark[0];
    }

    private void helper(int[] mark, int[][] grid, int row) {
        if (row < 0) return;

        int len = mark.length;
        mark[len - 1] += grid[row][len - 1];

        for (int j = len - 2; j >= 0; j--)
            mark[j] = grid[row][j] + Math.min(mark[j + 1], mark[j]);

        helper(mark, grid, row - 1);
    }

}
