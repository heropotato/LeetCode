/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/26/13
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class removeDuplicates {

    /*
    *
    * Remove Duplicates from Sorted Array
    *
    * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
    *
    * Do not allocate extra space for another array, you must do this in place with constant memory.
    *
    * */

    public static int removeDuplicates(int[] A) {

        int length = A.length;

        if (length < 2) {
            return length == 0 ? 0 : 1;
        }

        int i = 1;
        int runner = 1;
        //scan the array to find first element which is greater than A[i-1], then set the value to A[i]
        //then move i 1 position further, start scan from i
        while (runner < A.length) {
            if (A[runner] > A[i - 1]) {
                A[i] = A[runner];
                i++;
                runner = i;
            } else {
                runner++;
            }
        }
        return i;
    }

}
