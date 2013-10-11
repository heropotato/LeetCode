import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/10/13
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class uniquePathsWithObstacles {

    /*
    *
    * Unique Paths II
    *
    * Follow up for "Unique Paths":
    *
    * Now consider if some obstacles are added to the grids. How many unique paths would there be?
    *
    * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    *
    * For example,
    * There is one obstacle in the middle of a 3x3 grid as illustrated below.
    *
    * [
    *   [0,0,0],
    *   [0,1,0],
    *   [0,0,0]
    * ]
    *
    * The total number of unique paths is 2.
    *
    * Note: m and n will be at most 100.
    *
    *
    * */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Pretty same as "Unique Paths" solution except defining whether the position is obstacle or not.
        // If so, then set position's value to 0 (means no path available across)
        int[][] board = new int[100 + 1][100 + 1];
        int i = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < ints.length; j++) {
                board[i][j + 1] = ints[j];
            }
            i++;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        //pre set either (0,1) or (1,0) to 1 for assuring (1, 1) is 1
        board[0][1] = 1;

        for (int row = 1; row < m + 1; row++) {
            for (int column = 1; column < n + 1; column++) {
                if (board[row][column] == 1) {
                    board[row][column] = 0;
                } else {
                    board[row][column] = board[row - 1][column] + board[row][column - 1];
                }
            }
        }

        return board[m][n];
    }
}
