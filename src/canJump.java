/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/8/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class canJump {

    /*
    *
    * Jump Game
    *
    * Given an array of non-negative integers, you are initially positioned at the first index of the array.
    *
    * Each element in the array represents your maximum jump length at that position.
    *
    * Determine if you are able to reach the last index.
    *
    * For example:
    * A = [2,3,1,1,4], return true.
    *
    * A = [3,2,1,0,4], return false.
    *
    *
    * */

    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //canJump == can skip '0' positions? If so, return true; otherwise, return false;
        int i = 0;
        for (int a : A) {
            if (i == (A.length - 1)) return true;
            if (a == 0) {
                boolean res = false;
                for (int j = 0; j < i; j++) {
                    int offset = i - j;
                    if (A[j] > offset) {
                        res = true;
                        break;
                    }
                }
                if (!res) return false;
            }
            i++;
        }
        return true;
    }

}
