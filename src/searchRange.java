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
    * */

    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        if (A.length == 0) return res;
        if (A.length == 1) {
            if (A[0] == target) {
                res[0] = 0;
                res[1] = 0;
            }
            return res;
        }

        int leftRunner = 0;
        int rightRunner = A.length - 1;
        while (leftRunner <= rightRunner) {
            int position = (leftRunner + rightRunner) / 2;
            if (target < A[position]) {
                rightRunner = position - 1;
                continue;
            } else if (target > A[position]) {
                leftRunner = position + 1;
                continue;
            } else {
                int i = position;
                int j = position;

                while (i >= 0) {
                    if (A[i] == target) {
                        i--;
                    } else {
                        break;
                    }
                }

                while (j < A.length) {
                    if (A[j] == target) {
                        j++;
                    } else {
                        break;
                    }
                }

                res[0] = i + 1;
                res[1] = j - 1;
                return res;
            }
        }
        return res;
    }

}
