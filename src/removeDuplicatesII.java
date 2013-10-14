import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/13/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class removeDuplicatesII {

    /*
    *
    * Remove Duplicates from Sorted Array II
    *
    * Follow up for "Remove Duplicates":
    *
    * What if duplicates are allowed at most twice?
    *
    * For example,
    * Given sorted array A = [1,1,1,2,2,3],
    *
    * Your function should return length = 5, and A is now [1,1,2,2,3].
    *
    *
    * */

    public static void main(String[] args) {
        int[] test = {1,1,1};
        System.out.println(removeDuplicates(test));
        for (int i : test) {
            System.out.print(i + ", ");
        }
    }

    public static int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        if (A.length < 3) return A.length;
        HashMap<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
        int res = 0, i = 0;

        while (i < A.length) {
            if (countsMap.containsKey(A[i]) && countsMap.get(A[i]) > 1) {
                i++;
                while (i < A.length) {
                    if (!countsMap.containsKey(A[i]) || countsMap.get(A[i]) <= 1) break;
                    else i++;
                }
                if(i == A.length) return res;
            }
            removeDuplicatesAdd(countsMap, A[i]);
            removeDuplicatesSwap(A, i, res);
            i++;
            res++;
        }
        return res;
    }

    private static void removeDuplicatesSwap(int[] A, int indexA, int indexB) {
        int temp = A[indexA];
        A[indexA] = A[indexB];
        A[indexB] = temp;
    }

    private static void removeDuplicatesAdd(HashMap<Integer, Integer> countsMap, int a){
        if(!countsMap.containsKey(a)) countsMap.put(a, 1);
        else countsMap.put(a, countsMap.get(a)+1);
    }
}
