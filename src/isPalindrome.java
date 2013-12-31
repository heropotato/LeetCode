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

        // Constructing a reversed int without extra space
        // base case: negative number is considered as NON-palindrome
        // while(current > reverse)
        // in each round:
        // retrieve the last digit from current and add to the tail of the reverse
        // then, if current == 0, then reverse should be completed, return reverse == x
        // in this case: for example x = 5
        // otherwise, return (current == reverse) || current == (reverse / 10)
        // for example: x = 123321, or x = 1234321 respectively

        if (x < 0) return false;
        int current = x, reverse = 0;

        while (current > reverse) {
            reverse = reverse * 10 + current % 10;
            current /= 10;
        }

        if (current == 0) return (x == reverse);
        return (current == reverse) || current == (reverse / 10);
    }
}
