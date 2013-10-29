import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class singleNumberII {

    /*
    *
    * Single Number II
    *
    * Given an array of integers, every element appears three times except for one. Find that single one.
    *
    * Note:
    * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    *
    *
    * */

    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(A);
        for (int i = 0; i<A.length; i++){
            if(i+1<A.length && A[i] == A[i+1]) i+=2;
            else return A[i];
        }
        return A[A.length-1];
    }
 }
