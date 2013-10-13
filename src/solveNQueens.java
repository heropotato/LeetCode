import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/5/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class solveNQueens {

    /*
    *
    * N-Queens
    *
    * The n-queens puzzle is the problem of placing n queens on an n�n chessboard such that no two queens attack each other.
    *
    * Given an integer n, return all distinct solutions to the n-queens puzzle.
    *
    * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    *
    * */

    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();
        //use a int[n] to track all valid moves (position of 'Q')
        //do back trace row by row
        solveNQueens(n, 0, new int[n], res);
        return res;
    }

    private void solveNQueens(int n, int currentRow, int[] existedQueens, ArrayList<String[]> res) {
        if (currentRow == n) {
            String[] solution = new String[n];
            int row = 0;
            for (int col : existedQueens) {
                char[] tempRow = new char[n];
                Arrays.fill(tempRow, '.');
                tempRow[col] = 'Q';
                solution[row] = new String(tempRow);
                row++;
            }
            res.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidMove(currentRow, col, existedQueens)) {
                existedQueens[currentRow] = col;
                solveNQueens(n, currentRow + 1, existedQueens, res);
            }
        }
    }

    private boolean isValidMove(int row, int col, int[] queens) {
        int leftTop = col;
        int rightTop = col;
        for (int i = row - 1; i >= 0; i--) {
            leftTop--;
            rightTop++;
            if (queens[i] == col || queens[i] == leftTop || queens[i] == rightTop) return false;
        }
        return true;
    }
}
