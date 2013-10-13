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
    *
    * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    *
    * */

    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int length = A.length;

        if (length == 0) return 0;

        int i = 0;
        int runner = 0;
        length = 0;
        while (runner < A.length) {
            if (A[runner] != elem) {
                int temp = A[i];
                A[i] = A[runner];
                A[runner] = temp;
                i++;
                runner = i;
                length++;
            } else {
                runner++;
            }
        }

        return length;
    }

}
