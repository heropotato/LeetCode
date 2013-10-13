import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/8/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class spiralOrder {

    /*
    *
    * Spiral Matrix
    *
    * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    *
    * For example,
    * Given the following matrix:
    *
    *
    * [
    *   [ 1, 2, 3 ],
    *   [ 4, 5, 6 ],
    *   [ 7, 8, 9 ]
    * ]
    *
    *
    * You should return [1,2,3,6,9,8,7,4,5].
    *
    *
    * */

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return matrix.length == 0 ? new ArrayList<Integer>() : spiralOrder(0, 0, matrix.length, matrix[0].length, matrix, new ArrayList<Integer>());
    }

    private ArrayList<Integer> spiralOrder(int startRow, int startCol, int rowLength, int colLength, int[][] matrix, ArrayList<Integer> res) {

        if (rowLength - startRow == 1 || colLength - startCol == 1) {
            if (rowLength - startRow == 1 && colLength - startCol == 1) {
                res.add(matrix[startRow][startCol]);
            } else if (rowLength - startRow == 1) {
                for (int i = startCol; i < colLength - startCol; i++) {
                    res.add(matrix[startRow][i]);
                }
            } else {
                for (int i = startRow; i < rowLength - startRow; i++) {
                    res.add(matrix[i][startCol]);
                }
            }
            return res;
        }
        //top: left to right
        for (int i = startCol; i < colLength - startCol; i++) {
            if (i == colLength - startCol - 1) continue;
            res.add(matrix[startRow][i]);
        }
        //right side: top to bottom
        for (int i = startRow; i < rowLength - startRow; i++) {
            if (i == rowLength - startRow - 1) continue;
            res.add(matrix[i][colLength - startCol - 1]);
        }
        //bottom: right to left
        for (int i = colLength - startCol - 1; i >= startCol; i--) {
            if (i == startCol) continue;
            res.add(matrix[rowLength - startRow - 1][i]);
        }
        //left side: bottom up
        for (int i = rowLength - startRow - 1; i >= startRow; i--) {
            if (i == startRow) continue;
            res.add(matrix[i][startCol]);
        }

        if (startRow + 1 == (rowLength / 2) && startCol + 1 == (colLength / 2)) {
            if (startRow + 1 == (rowLength / 2) && rowLength % 2 == 1 && startCol + 1 == (colLength / 2) && colLength % 2 == 1) {
                res.add(matrix[startRow + 1][startCol + 1]);
            }
            return res;
        } else if (startRow + 1 == (rowLength / 2) && startCol + 1 != (colLength / 2)) {
            if (rowLength % 2 == 1) {
                startRow++;
                startCol++;
                for (int i = startCol; i < colLength - startCol; i++) {
                    res.add(matrix[startRow][i]);
                }
            }
        } else if (startRow + 1 != (rowLength / 2) && startCol + 1 == (colLength / 2)) {
            if (colLength % 2 == 1) {
                startRow++;
                startCol++;
                for (int i = startRow; i < rowLength - startRow; i++) {
                    res.add(matrix[i][colLength - startCol - 1]);
                }
            }
        } else {
            res.addAll(spiralOrder(startRow + 1, startCol + 1, rowLength, colLength, matrix, new ArrayList<Integer>()));
        }
        return res;
    }

}
