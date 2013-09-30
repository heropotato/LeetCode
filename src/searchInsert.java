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
        if (A.length < 2) {
            if (A.length == 0) return 0;
            return target <= A[0] ? 0 : 1;
        }

        int length = A.length;
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int pos = (start + end) / 2;
            if (target < A[pos]) {
                end = pos - 1;
            } else if (target > A[pos]) {
                start = pos + 1;
            } else {
                return pos;
            }
        }

        if (start == length) {
            return length;
        } else {
            if (target < A[start]) {
                if (start == 0) return 0;
                return start;
            } else {
                return start + 1;
            }
        }

    }
}
