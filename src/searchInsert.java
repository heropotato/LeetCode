/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/30/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class searchInsert {

    /*
    *
    * Search Insert Position
    *
    * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    *
    * You may assume no duplicates in the array.
    *
    * Here are few examples.
    *
    * [1,3,5,6], 5 → 2
    * [1,3,5,6], 2 → 1
    * [1,3,5,6], 7 → 4
    * [1,3,5,6], 0 → 0
    *
    * */

    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A.length == 0) return 0;
        int low = 0, high = A.length - 1;
        while (low < high) {
            int p = (low + high) / 2;
            if (A[p] > target) {
                high = p - 1;
            } else if (A[p] < target) {
                low = p + 1;
            } else {
                return p;
            }
        }

        int p = Math.min(low, high);
        if (p < 0 || p >= A.length) return p < 0 ? 0 : A.length;
        while (p < A.length && A[p] < target) p++;
        return p;
    }
}
