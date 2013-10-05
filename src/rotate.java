/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/5/13
 * Time: 12:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class rotate {

    /*
    *
    * Rotate Image
    *
    * You are given an n x n 2D matrix representing an image.
    *
    * Rotate the image by 90 degrees (clockwise).
    *
    * Follow up:
    * Could you do this in-place?
    *
    *
    *
    * */

    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = matrix.length;
        for (int layer = 0; layer < length / 2; layer++) {
            //head and tail index for each edge of layers
            int head = layer;
            int tail = length - head - 1;

            for (int i = head; i < tail; i++) {
                int offset = i - head;
                //swap
                int originTop = matrix[head][i];
                matrix[head][i] = matrix[tail - offset][head];
                matrix[tail - offset][head] = matrix[tail][tail - offset];
                matrix[tail][tail - offset] = matrix[i][tail];
                matrix[i][tail] = originTop;
            }
        }
    }

}
