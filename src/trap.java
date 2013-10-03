import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/2/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class trap {

    /*
    *
    * Trapping Rain Water
    *
    * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
    *
    * For example,
    * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
    *
    *
    * */

    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length < 3) return 0;
        int[] leftMax = new int[A.length], rightMax = new int[A.length];

        int i = 0;
        while (i < A.length) {
            leftMax[i] = i == 0 ? A[i] : Math.max(leftMax[i - 1], A[i]);
            i++;
        }

        i = A.length - 1;
        while (i >= 0) {
            rightMax[i] = i == A.length - 1 ? A[A.length - 1] : Math.max(A[i], rightMax[i + 1]);
            i--;
        }

        int res = 0;
        i = 1;
        while (i < A.length - 1) {
            res += Math.min(leftMax[i], rightMax[i]) - A[i];
            i++;
        }
        return res;
    }

}
