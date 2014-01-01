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
    * Do not allocate extra space for another array, you must do this in place with constant memory.
    *
    * */

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Iterate with a runner j from left to right on the given sorted array
        // Pointer i is tracking the tail of array in which duplicates removed
        // While pointer j is tracking the position of un-checked element on array
        // Due to the sorted array, A[j] is supposed to be greater than any previous elements
        // Otherwise, duplicates found
        if (A.length < 2) return A.length == 0? 0:1;

        int i = 1, j = 1;
        while (j < A.length) {
            if (A[j] > A[i - 1]) {
                A[i] = A[j];
                i++;
                j = i;
            } else j++;
        }
        return i;
    }
}
