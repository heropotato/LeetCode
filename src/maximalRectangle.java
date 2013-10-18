import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/18/13
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class maximalRectangle {

    /*
    *
    * Maximal Rectangle
    *
    * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
    *
    * */

    public int maximalRectangle(char[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (matrix.length == 0) return 0;
        int[][] intMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == 0) {
                    if (matrix[row][col] == '1') intMatrix[row][col] = 1;
                    else intMatrix[row][col] = 0;
                } else {
                    if (matrix[row][col] == '1') intMatrix[row][col] = intMatrix[row - 1][col] + 1;
                }
            }
        }

        int res = 0;
        for (int[] row : intMatrix) res = Math.max(res, largestRectangleArea(row));
        return res;
    }

    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int res = 0;
        Stack<Integer> barStack = new Stack<Integer>();

        for (int i = 0; i < height.length; i++) {
            if (barStack.empty() || height[i] > height[barStack.peek()]) {
                barStack.push(i);
            } else {
                int start = barStack.pop();
                int width = barStack.empty() ? i : i - 1 - barStack.peek();
                res = Math.max(res, height[start] * width);
                i--;
            }
        }

        while (!barStack.empty()) {
            int start = barStack.pop();
            int width = barStack.empty() ? height.length : height.length - 1 - barStack.peek();
            res = Math.max(res, height[start] * width);
        }
        return res;
    }
}
