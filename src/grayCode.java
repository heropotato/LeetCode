import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/18/13
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class grayCode {

    /*
    *
    * Gray Code
    *
    * The gray code is a binary numeral system where two successive values differ in only one bit.
    *
    * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
    *
    * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
    *
    * 00 - 0
    * 01 - 1
    * 11 - 3
    * 10 - 2
    * Note:
    * For a given n, a gray code sequence is not uniquely defined.
    *
    * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
    *
    * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
    *
    *
    * */

    public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        ArrayList<Integer> tempRes = new ArrayList<Integer>();

        // base cases:
        if (n <= 1) {
            tempRes.add(0);
            if (n == 1) tempRes.add(1);
            return tempRes;
        }

        ArrayList<Integer> prevList = grayCode(n - 1);
        int highest_bit = 1 << (n - 1);
        for (int i = prevList.size() - 1; i >= 0; i--) {
            tempRes.add(prevList.get(i) + highest_bit);
        }

        prevList.addAll(tempRes);
        return prevList;
    }
}
