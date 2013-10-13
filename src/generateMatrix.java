/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/9/13
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class generateMatrix {

    /*
    *
    * Spiral Matrix II
    *
    * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    *
    * For example,
    * Given n = 3,
    *
    * You should return the following matrix:
    * [
    *  [ 1, 2, 3 ],
    *  [ 8, 9, 4 ],
    *  [ 7, 6, 5 ]
    * ]
    *
    *
    * */

    public static void main(String[] args) {
        for (int[] ints : generateMatrix(9)) {
            int count = 0;
            for (int i : ints) {
                System.out.print(i);
                if (count == ints.length - 1) {
                    System.out.println(". ");
                } else {
                    System.out.print(",     ");
                }
                count++;
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] res = new int[n][n];
        int basePoint = n % 2 == 0 ? n / 2 - 1 : n / 2;
        generateMatrix(0, 0, n, res, 1, basePoint);
        return res;
    }

    public static void generateMatrix(int startRow, int startCol, int n, int[][] matrix, int count, int basePoint) {

        if (startRow == basePoint && n % 2 != 0) {
            matrix[startRow][startCol] = count;
            return;
        }
        //top: left to right
        for (int i = startCol; i < n - startCol; i++) {
            if (i == n - startCol - 1) continue;
            matrix[startRow][i] = count;
            count++;
        }
        //right side: top down
        for (int i = startRow; i < n - startRow; i++) {
            if (i == n - startRow - 1) continue;
            matrix[i][n - startCol - 1] = count;
            count++;
        }
        //bottom: right to left
        for (int i = n - startCol - 1; i >= startCol; i--) {
            if (i == startCol) continue;
            matrix[n - startRow - 1][i] = count;
            count++;
        }
        //left side: bottom up
        for (int i = n - startRow - 1; i >= startRow; i--) {
            if (i == startRow) continue;
            matrix[i][startCol] = count;
            count++;
        }

        if (startRow + 1 <= basePoint) {
            generateMatrix(startRow + 1, startCol + 1, n, matrix, count, basePoint);
        }

    }

}
