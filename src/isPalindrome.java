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
        if(x < 0) return false;

        int a = x, b = 0;
        while (a>b){
            b = b*10 + a%10;
            a /= 10;
        }

        if(a == 0) return (x==b);
        return (a == b) || a == (b / 10);
    }
}
