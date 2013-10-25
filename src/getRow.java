import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class getRow {

    /*
    *
    * Pascal's Triangle II
    *
    * Given an index k, return the kth row of the Pascal's triangle.
    *
    *
    * For example, given k = 3,
    * Return [1,3,3,1].
    *
    *
    *
    * Note:
    * Could you optimize your algorithm to use only O(k) extra space?
    *
    *
    * */

    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by eac
        ArrayList<Integer> row = new ArrayList<Integer>();
        // iterate current row k times
        // each time add up each cell according to the question
        for (int i = 0; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 0; j <= i; j++) {
                if (j > 0 && j < i) {
                    int cur = row.get(j);
                    row.set(j, prev + cur);
                    prev = cur;
                } else if (i == 0 || j == i) {
                    row.add(1);
                }
            }
        }
        return row;
    }
}
