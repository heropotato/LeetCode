/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 1:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class minPathSum {

    /*
    *
    * Minimum Path Sum
    *
    * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    *
    * Note: You can only move either down or right at any point in time.
    *
    *
    * */

    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (row == 0 && column == 0) {
                    continue;
                } else if (row == 0) {
                    grid[row][column] += grid[row][column - 1];
                } else if (column == 0) {
                    grid[row][column] += grid[row - 1][column];
                } else {
                    grid[row][column] += Math.min(grid[row - 1][column], grid[row][column - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
