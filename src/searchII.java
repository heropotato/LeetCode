/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/14/13
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class searchII {

    /*
    *
    * Search in Rotated Sorted Array II
    *
    * Follow up for "Search in Rotated Sorted Array":
    *
    * What if duplicates are allowed?
    *
    * Would this affect the run-time complexity? How and why?
    *
    * Write a function to determine if a given target is in the array.
    *
    *
    * */

    public boolean search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) return false;

        for (int i:A){
            if (i == target) return true;
        }

        return false;
    }
}
