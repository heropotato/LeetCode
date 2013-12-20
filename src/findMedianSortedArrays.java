/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/12/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class findMedianSortedArrays {
    /*
        Median of Two Sorted Arrays

        There are two sorted arrays A and B of size m and n respectively.
        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    */

    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length, n = B.length;

        // Base cases:
        // either A or B is null, then return the "median" element of the other
        // if k == 0, then return min(A[startA], B[startB])
        if (m == 0) return n % 2 == 1 ? B[n / 2] : (double) (B[n / 2 - 1] + B[n / 2]) / 2.;
        if (n == 0) return m % 2 == 1 ? A[m / 2] : (double) (A[m / 2 - 1] + A[m / 2]) / 2.;

        int k = findKthElement(A, B, (m + n) / 2 + 1);

        // deal with scenario that m+n is even
        int k1 = k;
        if ((m + n) % 2 == 0) k1 = findKthElement(A, B, (m + n) / 2);
        return (double) (k + k1) / 2.0;
    }

    public int findKthElement(int A[], int B[], int k) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int cur = (start + end) / 2;
            if (cur < k && k <= B.length + cur + 1 && (k == cur + 1 || A[cur] >= B[k - 2 - cur]) && (k > cur + B.length || A[cur] <= B[k - 1 - cur])) {
                return A[cur];
            } else if (cur >= k || (k <= cur + B.length && A[cur] > B[k - 1 - cur])) {
                end = cur - 1;
            } else {
                start = cur + 1;
            }
        }
        return findKthElement(B, A, k);
    }

    /*
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int m = A.length, n = B.length;

        if (m == 0) return n % 2 == 1 ? B[n / 2] : (double) (B[n / 2 - 1] + B[n / 2]) / 2;
        if (n == 0) return m % 2 == 1 ? A[m / 2] : (double) (A[m / 2 - 1] + A[m / 2]) / 2;

        int totalLength = m + n;
        ArrayList<Integer> merge = new ArrayList<Integer>();

        int pointerA = 0, pointerB = 0, targetPos = totalLength / 2;

        while (targetPos >= 0) {
            targetPos--;
            if (pointerA < m && pointerB < n) {
                if (A[pointerA] < B[pointerB]) {
                    merge.add(A[pointerA]);
                    pointerA++;
                } else {
                    merge.add(B[pointerB]);
                    pointerB++;
                }
                continue;
            }else {
                if (pointerA < m) {
                    merge.add(A[pointerA]);
                    pointerA++;
                }else{
                    merge.add(B[pointerB]);
                    pointerB++;
                }
            }
        }

        int size = merge.size();
        if (totalLength % 2 == 1 || size == 1) return merge.get(size - 1);
        else return (double) (merge.get(size - 1) + merge.get(size - 2)) / 2;

    }
    */
}
