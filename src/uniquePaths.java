
/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/10/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class uniquePaths {

    /*
    *
    * Unique Paths
    *
    * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    *
    * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    *
    * How many possible unique paths are there?
    *
    * Note: m and n will be at most 100
    *
    * */

    public int uniquePaths(int m, int n) {

        //initialize a board as 101*101 (due to the question, max row/column is 100)
        //due to the top down approach, a pre row and pre column have to be taken into account
        //start point is (1,1) rather than (0,0)
        int[][] board = new int[100 + 1][100 + 1];

        //pre set either (0,1) or (1,0) to 1 for assuring (1, 1) is 1
        board[0][1] = 1;

        for (int row = 1; row < m + 1; row++) {
            for (int column = 1; column < n + 1; column++) {
                board[row][column] = board[row - 1][column] + board[row][column - 1];
            }
        }

        return board[m][n];
    }

 /*
    public static int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return backtrack(0, 0, m-1, n-1);
    }


    public static int backtrack(int startRow, int startCol, int targetRow, int targetCol) {
        if (startRow == targetRow && startCol == targetCol) return 1;
        if (startRow > targetRow || startCol > targetCol) return 0;
        return backtrack(startRow+1, startCol, targetRow, targetCol) + backtrack(startRow, startCol+1, targetRow, targetCol);
    }

    */

/*

    public static int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<int[][]> res = new ArrayList<int[][]>();
        uniquePaths(0, 0, new int[m][n], res, m, n);
        return res.size();
    }

    private static void uniquePaths(int startRow, int startCol, int[][] board, ArrayList<int[][]> solutions, int rowSize, int colSize){

        if(startRow == (rowSize-1) && startCol == (colSize-1)){
            solutions.add(board);
            return;
        }

        if(startRow == rowSize -1){
            for(int i = startCol; i<colSize; i++){
                if(board[startRow][i] == 1) return;
                board[startRow][i] = 1;
            }
            solutions.add(board);
            return;
        }

        if(startCol == colSize -1){
            for(int i = startRow; i<rowSize; i++){
                if(board[i][startCol] == 1) return;
                board[i][startCol] = 1;
            }
            solutions.add(board);
            return;
        }

        if(board[startRow][startCol] == 1){
            return;
        }else {
            board[startRow][startCol] = 1;
        }

        int[][] temp = new int[rowSize][colSize];
        int i = 0;
        for (int[] ints : board){
            temp[i] = Arrays.copyOf(ints, colSize);
            i++;
        }

        uniquePaths(startRow+1, startCol, temp, solutions, rowSize, colSize);
        uniquePaths(startRow, startCol+1, board, solutions, rowSize, colSize);

    }
*/

}
