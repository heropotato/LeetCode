import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/7/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class maxSubArray {

    /*
    *
    * Maximum Subarray
    *
    * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    *
    * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
    *
    * */

    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 1) return A[0];
        int res = Integer.MIN_VALUE;
        int i = 0;
        Stack<Integer> mostRight = new Stack<Integer>();
        while (i<A.length){
            int left = i-1, right = i+1, leftMax = 0, rightMax = 0, leftSum = leftMax, rightSum = rightMax;
            while (left >= 0) {
                leftSum += A[left];
                if(leftSum>leftMax) leftMax = leftSum;
                left--;
            }
            while (right < A.length) {
                rightSum += A[right];
                if(rightSum>rightMax) {
                    rightMax = rightSum;
                    mostRight.push(right);
                }
                right++;
            }
            if (leftMax + rightMax + A[i] > res ) res = leftMax + rightMax + A[i];
            if(!mostRight.isEmpty() && mostRight.peek() > i){
                i = mostRight.peek();
            }else {
                i++;
            }
        }
        return res;
    }
}
