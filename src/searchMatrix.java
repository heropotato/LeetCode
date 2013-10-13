/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/12/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class searchMatrix {

    /*
    *
    * Search a 2D Matrix
    *
    * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    *
    * Integers in each row are sorted from left to right.
    * The first integer of each row is greater than the last integer of the previous row.
    * For example,
    *
    * Consider the following matrix:
    *
    * [
    *   [1,   3,  5,  7],
    *   [10, 11, 16, 20],
    *   [23, 30, 34, 50]
    * ]
    *
    * Given target = 3, return true.
    *
    *
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (matrix.length == 0 || target < matrix[0][0]) return false;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int[] rowStarts = new int[rowSize];
        for (int i = 0; i < rowSize; i++) {
            rowStarts[i] = matrix[i][0];
        }

        int rowCandidate = searchMatrix(rowStarts, 0, rowSize - 1, target);
        if (matrix[rowCandidate][0] > target) {
            if (rowCandidate == 0) return false;
            rowCandidate--;
        }
        int colCandidate = searchMatrix(matrix[rowCandidate], 0, colSize - 1, target);
        return matrix[rowCandidate][colCandidate] == target;

    }

    private int searchMatrix(int[] array, int start, int end, int target) {
        if (start == end) return start;
        int position = (start + end) / 2;
        if (target == array[position]) {
            return position;
        } else if (target > array[position]) {
            if (position == end) return position;
            return searchMatrix(array, position + 1, end, target);
        } else {
            if (position == start) return position;
            return searchMatrix(array, start, position - 1, target);
        }
    }
}
