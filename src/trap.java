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
    * */

    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Iterate the array from left to right, find out highest bar on the left side of each position i
        // then, vice versa, iterate from right to left
        // then, accumulate how much water can be trapped at each position i
        int[] lMax = new int[A.length], rMax = new int[A.length];
        int res = 0;
        for (int i = A.length-1; i>=0; i--){
            rMax[i] = i == A.length-1?A[i]:Math.max(A[i], rMax[i+1]);
        }
        for (int i = 0; i < A.length; i++){
            lMax[i] = i == 0?A[i]:Math.max(A[i], lMax[i-1]);
            res += Math.min(lMax[i], rMax[i]) - A[i];
        }
        return res;
    }
}
