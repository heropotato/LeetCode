import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/27/13
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class divide {

    /*
    *
    * Divide Two Integers
    *
    * Divide two integers without using multiplication, division and mod operator.
    *
    *
    * */

    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long dividendABS = Math.abs((long) dividend), divisorABS = Math.abs((long) divisor);

        ArrayList<Long> divisorsShiftList = new ArrayList<Long>();
        while (dividendABS >= divisorABS) {
            divisorsShiftList.add(divisorABS);
            divisorABS = divisorABS << 1;
        }

        int res = 0, i = divisorsShiftList.size() - 1;
        while (dividendABS > 0 && i >= 0) {
            while (dividendABS >= divisorsShiftList.get(i)) {
                dividendABS -= divisorsShiftList.get(i);
                res += (1<<i);
            }
            i--;
        }

        return (long) dividend * (long) divisor < 0L ? -res : res;

    }

}
