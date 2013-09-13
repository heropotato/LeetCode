/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class isPalindrome {
   /*
    * May 17, 2013
    *
    * Palindrome Number
    *
    * Determine whether an integer is a palindrome. Do this without extra space.
    *
    */

    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) return false;

        //Find out highest digit pos of the given int
        int pos = 1;

        while (x / pos >= 10) pos *= 10;

        //Compare head against tail of the given int outside in
        while (x > 0) {
            int head = x / pos;
            int tail = x % 10;
            if (head != tail) return false;

            x = (x % pos) / 10;
            pos /= 100;
        }
        return true;
    }
}
