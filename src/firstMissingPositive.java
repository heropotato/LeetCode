import java.util.Random;

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
    * Given [1,2,0] return 3,
    * and [3,4,-1,1] return 2.
    *
    * Your algorithm should run in O(n) time and uses constant space.
    *
    * */

    public static int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // For a sorted without any missing positive integer:
        // Then, A[i] = i+1;
        // Iterate the given array, if any element cannot satisfy A[i] = i+1,
        // then swap it to its "supposed to be" position, which is i = A[i] - 1;
        // swap (A[i], A[A[i] - 1])
        int i = 0;
        while (i < A.length) {
            if (A[i] != i + 1 && A[i] > 0 && A[i] < A.length && A[i] != A[A[i] - 1]) swap(A, A[i]-1, i);
            else i++;
        }

        for (i=0; i<A.length && A[i] == i+1; i++);
        return i+1;
    }

    private static void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
