/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/27/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class removeElement {

    /*
    *
    * Remove Element
    *
    * Given an array and a value, remove all instances of that value in place and return the new length.
    * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    *
    * */

    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Really simple solution:
        // find any one different than the given element
        if (A.length == 0) return 0;
        int i = 0, j = 0;
        for (; j < A.length; j++) {
            if (A[j] != elem) {
                A[i] = A[j];
                i++;
            }
        }
        return i;
    }
}
