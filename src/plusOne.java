import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class plusOne {

    /*
    *
    * Plus One
    *
    * Given a number represented as an array of digits, plus one to the number.
    *
    * */

    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean plusFlag = false;
        int i = digits.length - 1;
        if ((digits[i] + 1) / 10 > 0) plusFlag = true;
        digits[i] = (digits[i] + 1) % 10;
        i--;
        while (i >= 0 && plusFlag) {
            plusFlag = (digits[i] + 1) / 10 > 0 ? true : false;
            digits[i] = (digits[i] + 1) % 10;
            i--;
        }
        if (plusFlag) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            int j = 1;
            for (int digit : digits) {
                res[j] = digit;
                j++;
            }
            return res;
        } else {
            return digits;
        }
    }
}
