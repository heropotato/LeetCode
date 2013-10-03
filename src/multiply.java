import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/3/13
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class multiply {

    /*
    *
    *
    * Multiply Strings
    *
    * Given two numbers represented as strings, return multiplication of the numbers as a string.
    *
    * Note: The numbers can be arbitrarily large and are non-negative.
    *
    *
    * */

    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function

        //Properly use BigInteger rather than Long or Integer here:
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

 }
