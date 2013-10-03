/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/2/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class firstMissingPositive {

    /*
    *
    * First Missing Positive
    *
    * Given an unsorted integer array, find the first missing positive integer.
    *
    * For example,
    *
    * Given [1,2,0] return 3,
    * and [3,4,-1,1] return 2.
    *
    *
    * Your algorithm should run in O(n) time and uses constant space.
    *
    * */

    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //Notes:
        //1, positive integer start from 1
        //2, according to note 1, each integer and its position should be as A[i] = i+1
        //3, according to the relationship described as note 2, traverse the array and swap integer which is not located corresponding positions
        //4, traverse the swapped array, find out the missing integer
        int i=0;
        while(i<A.length){
            if(A[i]!=i+1 && A[i]>0 && A[i]<A.length && A[i]!=A[A[i]-1]){
                //swap here:
                int swap = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = swap;
            }else{
                i++;
            }
        }

        i=0;
        while (i<A.length && A[i]==i+1) i++;
        return i+1;
    }

 }
