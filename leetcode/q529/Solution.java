package demo.leetcode.q529;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. 扫雷游戏
 * <p>
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Click : [1,2]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class Solution {

    private int rangeY;// 高度，行range
    private int rangeX;// 宽度，列range

    /**
     * 一维数组整体代表列
     * 二维数组整体代表行
     * 点到M，将其改为X，直接返回
     * 点到E{
     * 判断其周围有无M
     * 如有，将其改为周边M数量
     * 如无，将其改为B，并且点击其周围所有（最多8个）E
     * }
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

        this.rangeY = board.length;
        this.rangeX = board[0].length;

        // 需要点击的队列
        Queue<Local> queue = new LinkedList<>();
        queue.add(new Local(click[1], click[0]));
        while (!queue.isEmpty()) {
            Local curr = queue.poll();
            if (board[curr.y][curr.x] != 'E') continue;
            int round = this.roundMineCount(board, curr);
            if (round > 0) {
                board[curr.y][curr.x] = (char) (48 + round);
            } else {
                board[curr.y][curr.x] = 'B';
                for (int y = curr.y - 1; y <= curr.y + 1 && y < rangeY; y++) {
                    if (y < 0) continue;
                    for (int x = curr.x - 1; x <= curr.x + 1 && x < rangeX; x++) {
                        if (x < 0 || curr.x == x && curr.y == y) continue;
                        queue.add(new Local(x, y));
                    }
                }
            }
        }
        return board;
    }

    /**
     * 点击E时调用这个方法，返回周边地雷数量
     *
     * @param board
     * @param click
     * @return
     */
    private int roundMineCount(char[][] board, Local click) {
        int count = 0;
        for (int y = click.y - 1; y <= click.y + 1 && y < rangeY; y++) {
            if (y < 0) continue;
            for (int x = click.x - 1; x <= click.x + 1 && x < rangeX; x++) {
                if (x < 0 || (click.x == x && click.y == y)) continue;
                if (board[y][x] == 'M') count++;
            }
        }
        return count;
    }

    class Local {
        int x;// 列下标
        int y;// 行下标

        Local(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
