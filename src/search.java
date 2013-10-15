/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/28/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class search {

    /*
    *
    * Search in Rotated Sorted Array
    *
    * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    *
    * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    *
    * You are given a target value to search. If found in the array return its index, otherwise return -1.
    *
    * You may assume no duplicate exists in the array.
    *
    *
    * */

    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (A.length == 0) return -1;
        if (A.length == 1) return (A[0] == target ? 0 : -1);

        int startIndex = 0;
        int endIndex = A.length - 1;

        while (startIndex <= endIndex) {
            int tempPosition = (startIndex + endIndex) / 2;

            if (target < A[tempPosition]) {
                if (A[tempPosition] < A[endIndex])
                    endIndex = tempPosition - 1;
                else {
                    if (target > A[endIndex])
                        endIndex = tempPosition - 1; //due to the rotated list, if target > A[tempPosition] && target > A[endIndex], then target is supposed to be among 1st half of the list
                    else startIndex = tempPosition + 1;
                }
            } else if (target > A[tempPosition]) {
                if (A[tempPosition] < A[endIndex]) {
                    if (target > A[endIndex]) endIndex = tempPosition - 1;
                    else startIndex = tempPosition + 1;
                } else {
                    startIndex = tempPosition + 1;
                }
            } else {
                return tempPosition;
            }
        }
        return -1;
    }
}
