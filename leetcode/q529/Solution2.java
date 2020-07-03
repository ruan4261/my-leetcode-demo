package demo.leetcode.q529;

public class Solution2 {

    // 方位缓存
    private int[][] roundLocal = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    /**
     * 走递归
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        int rowRange = board.length;
        int colRange = board[0].length;

        // 判断周围是否有雷
        int round = 0;
        for (int[] l : roundLocal) {
            int row = click[0] - l[0];
            int col = click[1] - l[1];
            if (row >= 0 && col >= 0 && row < rowRange && col < colRange && board[row][col] == 'M') round++;
        }
        if (round > 0) {
            board[click[0]][click[1]] = (char) ('0' + round);
            return board;
        } else board[click[0]][click[1]] = 'B';

        // 循环递归周围格
        for (int[] l : roundLocal) {
            int row = click[0] - l[0];
            int col = click[1] - l[1];
            if (row >= 0 && col >= 0 && row < rowRange && col < colRange && board[row][col] == 'E') {
                updateBoard(board, new int[]{row, col});
            }
        }
        return board;
    }
}
