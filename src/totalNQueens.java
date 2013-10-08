import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/7/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class totalNQueens {

    /*
    *
    * N-Queens II
    *
    * Follow up for N-Queens problem.
    *
    * Now, instead outputting board configurations, return the total number of distinct solutions.
    *
    * */

    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<int[]> solutions = new ArrayList<int[]>();
        solveNQueens(n, 0, new int[n], solutions);
        return solutions.size();
    }

    private void solveNQueens(int n, int currentRow, int[] existedQueens, ArrayList<int[]> res) {
        if (currentRow == n) {
            res.add(existedQueens);
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
