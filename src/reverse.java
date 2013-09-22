/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class reverse {
        /*
    *
    * May 17, 2013
    *
    * Reverse Integer
    *
    * Reverse digits of an integer.
    *
    * Example1: x = 123, return 321
    * Example1: x = -123, return -321
    *
    *
    * */

    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (x < 0) {
            return -Integer.valueOf(new StringBuffer().append(-x).reverse().toString());
        } else {
            return Integer.valueOf(new StringBuffer().append(x).reverse().toString());
        }
    }
}
