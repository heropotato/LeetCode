/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/30/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class searchInsert {

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
