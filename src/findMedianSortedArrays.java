import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/12/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class findMedianSortedArrays {
    /*
        There are two sorted arrays A and B of size m and n respectively.

        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    */
    public static double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int lengthA = A.length;
        int lengthB = B.length;

        if (lengthA == 0) return lengthB % 2 == 1 ? B[lengthB / 2] : (double) (B[lengthB / 2 - 1] + B[lengthB / 2]) / 2;
        if (lengthB == 0) return lengthA % 2 == 1 ? A[lengthA / 2] : (double) (A[lengthA / 2 - 1] + A[lengthA / 2]) / 2;

        int totalLength = lengthA + lengthB;
        ArrayList<Integer> existed = new ArrayList<Integer>();

        int pointerA = 0, pointerB = 0;
        int targetPos = totalLength / 2;

        while (targetPos >= 0) {
            targetPos--;
            if (pointerA < lengthA && pointerB < lengthB) {
                if (A[pointerA] < B[pointerB]) {
                    existed.add(A[pointerA]);
                    pointerA++;
                } else {
                    existed.add(B[pointerB]);
                    pointerB++;
                }
            } else if (pointerA < lengthA) {
                existed.add(A[pointerA]);
                pointerA++;
            } else {
                existed.add(B[pointerB]);
                pointerB++;
            }
        }

        if (totalLength % 2 == 1 || existed.size() == 1) {
            return existed.get(existed.size() - 1);
        } else {
            return (double) (existed.get(existed.size() - 1) + existed.get(existed.size() - 2)) / 2;
        }

    }
}
