package demo.leetcode.q463;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int high = grid.length, width = grid[0].length;
        int lastH = high - 1, lastW = width - 1;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) count++;
                    if (i == lastH || grid[i + 1][j] == 0) count++;
                    if (j == 0 || grid[i][j - 1] == 0) count++;
                    if (j == lastW || grid[i][j + 1] == 0) count++;
                }
            }
        }
        return count;
    }
}
