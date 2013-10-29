import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class singleNumber {

    /*
    *
    * Single Number
    *
    * Given an array of integers, every element appears twice except for one. Find that single one.
    *
    * Note:
    * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    *
    *
    * */

    public static int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(A);
        for (int i=0; i<A.length; i++){
            if(i+1<A.length && A[i] == A[i+1]) i++;
            else return A[i];
        }
        return A[A.length-1];
    }
 }
