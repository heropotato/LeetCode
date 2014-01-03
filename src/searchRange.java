/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/28/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class searchRange {
    /*
    *
    * Search for a Range
    *
    * Given a sorted array of integers, find the starting and ending position of a given target value.
    *
    * Your algorithm's runtime complexity must be in the order of O(log n).
    *
    * If the target is not found in the array, return [-1, -1].
    *
    *
    * */

    public static void main(String[] args) {
        int[] a = {1};
        searchRange(a, 1);
    }

    public static int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Use binary search to find the position of target value
        int[] res = {-1, -1};
        if (A.length == 0) return res;

        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int p = (low + high) / 2;
            if (target < A[p]) high = p - 1;
            else if (target > A[p]) low = p + 1;
            else {
                int i = p, j = p;
                while (i >= 0 && A[i] == target) i--;
                while (j < A.length && A[j] == target) j++;
                res[0] = i + 1;
                res[1] = j - 1;
                return res;
            }
        }
        return res;
    }

}
