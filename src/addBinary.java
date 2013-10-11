import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 2:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class addBinary {

    /*
    *
    * Add Binary
    *
    * Given two binary strings, return their sum (also a binary string).
    *
    * For example,
    * a = "11"
    * b = "1"
    * Return "100".
    *
    *
    * */

    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function

        return new BigInteger(b, 2).add(new BigInteger(a, 2)).toString(2);

    }
}
