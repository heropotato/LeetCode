import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/18/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class mergeII {

    /*
    *
    * Merge Sorted Array
    *
    * Given two sorted integer arrays A and B, merge B into A as one sorted array.
    *
    * Note:
    *
    * You may assume that A has enough space to hold additional elements from B.
    * The number of elements initialized in A and B are m and n respectively.
    *
    *
    * */

    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int indexA = m-1, indexB = n-1, indexRes = m+n-1;
        while(indexRes>=0){
            if(indexB<0 || (indexA>=0 && A[indexA] > B[indexB])){
                A[indexRes--] = A[indexA--];
            }else{
                A[indexRes--] = B[indexB--];
            }
        }
    }
}
