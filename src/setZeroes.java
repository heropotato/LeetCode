import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/12/13
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class setZeroes {

    /*
    *
    * Set Matrix Zeroes
    *
    *
    * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
    *
    * */

    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (matrix.length == 0) return;

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        ArrayList<Integer> rowFlag = new ArrayList<Integer>();
        ArrayList<Integer> colFlag = new ArrayList<Integer>();

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag.add(i);
                    colFlag.add(j);
                }
            }
        }

        for (Integer row : rowFlag) {
            Arrays.fill(matrix[row], 0);
        }
        for (Integer col : colFlag) {
            for (int r = 0; r < rowSize; r++) {
                matrix[r][col] = 0;
            }
        }
    }
}
