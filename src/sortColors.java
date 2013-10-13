/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/12/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class sortColors {

    /*
    *
    * Sort Colors
    *
    * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
    *
    * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    *
    * Note:
    * You are not suppose to use the library's sort function for this problem.
    *
    * Follow up:
    * A rather straight forward solution is a two-pass algorithm using counting sort.
    * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    *
    * Could you come up with an one-pass algorithm using only constant space?
    *
    *
    *
    * */

    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int i = 0, whiteStart = 0, whiteEnd = A.length - 1;
        while (i <= whiteEnd) {
            if (A[i] == 0) {
                sortColors(A, i, whiteStart);
                whiteStart++;
                i++;
            } else if (A[i] == 2) {
                sortColors(A, i, whiteEnd);
                whiteEnd--;
            } else {
                i++;
            }
        }
    }

    private void sortColors(int[] A, int indexA, int indexB) {
        if (indexA == indexB || A[indexA] == A[indexB]) return;
        int temp = A[indexA];
        A[indexA] = A[indexB];
        A[indexB] = temp;
    }
}
