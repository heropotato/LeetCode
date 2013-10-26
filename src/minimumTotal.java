import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class minimumTotal {

    /*
    *
    * Triangle
    *
    * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    *
    *
    * For example, given the following triangle
    *
    * [
    *       [2],
    *      [3,4],
    *     [6,5,7],
    *    [4,1,8,3]
    * ]
    *
    * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    *
    * Note:
    * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    *
    *
    *
    * */

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test

        // get inspired from http://discuss.leetcode.com/questions/285/triangle/728
        // a really neat solution:

        // two-dimensional DP
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int position = 0; position < triangle.get(row).size(); position++) {
                triangle.get(row).set(position, triangle.get(row).get(position) + Math.min(triangle.get(row + 1).get(position), triangle.get(row + 1).get(position + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
