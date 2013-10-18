import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/16/13
 * Time: 1:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class largestRectangleArea {

    /*
    *
    * Largest Rectangle in Histogram
    *
    * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
    *
    * For example,
    *
    * Given height = [2,1,5,6,2,3],
    *
    * return 10.
    *
    * */

    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // get inspired from http://blog.csdn.net/abcbc/article/details/8943485

        // use Stack to track each bar index from left to right:
        // if stack isEmpty() or current bar height is greater than the stack.peek(), then push the current bar index to the stack;
        // else remain the i, pop stack until it's empty,
        // in each round: calculate the temp area between current bar and the one, which at end of the stack
        // record the largest area

        int res = 0;
        Stack<Integer> barStack = new Stack<Integer>();

        for (int i = 0; i < height.length; i++) {
            if (barStack.empty() || height[i] > height[barStack.peek()]) {
                barStack.push(i);
            } else {
                int start = barStack.pop();
                int width = barStack.empty() ? i : i -1 - barStack.peek();
                res = Math.max(res, height[start] * width);
                i--;
            }
        }

        while (!barStack.empty()) {
            int start = barStack.pop();
            int width = barStack.empty() ? height.length : height.length -1 - barStack.peek();
            res = Math.max(res, height[start] * width);
        }
        return res;
    }
}
