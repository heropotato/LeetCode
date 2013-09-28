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
    * */

    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(A.length <1) return -1;
        int first = A[0];
        int last = A[A.length-1];

        if(last > first){
            if(target < first || target > last) return -1;
            if(Math.abs(target - first) > Math.abs(target - last)){
                int i = A.length-1;
                while(i>=0){
                    if(A[i] == target) return i;
                    i--;
                }
                return -1;
            }else{
                int i = 0;
                while(i<A.length){
                    if(A[i] == target) return i;
                    i++;
                }
                return -1;
            }
        }else{
            if(target >= first){
                int i = 0;
                while(i<A.length){
                    if(A[i] == target) return i;
                    i++;
                }
                return -1;

            }else{
                int i = A.length-1;
                while(i>=0){
                    if(A[i] == target) return i;
                    i--;
                }
                return -1;
            }
        }
    }
}
