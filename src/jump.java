import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/4/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class jump {

/*
*
* Jump Game II
*
* Given an array of non-negative integers, you are initially positioned at the first index of the array.
*
* Each element in the array represents your maximum jump length at that position.
*
* Your goal is to reach the last index in the minimum number of jumps.
*
*
* For example:
* Given array A = [2,3,1,1,4]
*
* The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*
*
* */

    public int jump(int[] A) {
        int steps = 0;
        for (int i = 1, maxMoveToPos = A[0], forwardRunner = 0; i < A.length; i++) {
            if (i > forwardRunner) {
                forwardRunner = maxMoveToPos;
                steps++;
            }
            maxMoveToPos = Math.max(maxMoveToPos, i + A[i]);
        }
        return steps;
    }
}
