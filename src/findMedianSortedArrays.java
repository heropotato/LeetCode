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

        //total number of elements in both arrays
        int total = lengthA + lengthB;

        int count = 0;
        int pointerA = lengthA - 1;
        int pointerB = lengthB - 1;

        int res = 0;
        int temp = 0;

        while (count <= (total / 2 + 1)) {

            if (pointerA >= 0 && pointerB >= 0) {
                if (A[pointerA] < B[pointerB]) {
                    res = B[pointerB];
                    pointerB--;
                } else {
                    res = A[pointerA];
                    pointerA--;
                }
            } else if (pointerA >= 0) {
                res = A[pointerA];
                pointerA--;
            } else {
                res = B[pointerB];
                pointerB--;
            }

            if (count == total / 2) {
                temp = res;
            }
            count++;
        }

        if (total % 2 == 1) {
            return (double) temp;
        } else {
            return (double) (temp + res) / 2;
        }

    }

}
