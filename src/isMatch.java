/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class isMatch {
   /*
    *
    * May 17, 2013
    *
    * Regular Expression Matching
    *
    * Implement regular expression matching with support for '.' and '*'.
    *
    * '.' Matches any single character.
    *
    * '*' Matches zero or more of the preceding element.
    *
    **/

     public boolean isMatch(String s, String p) {
        //Java note: s.substring(n) will be "" if n == s.length(), but if n > s.length(), index oob error
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s.length() == 0) {
            return checkEmpty(p);
        }

        if (p.length() == 0) {
            return false;
        }

        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do

        if (p.length() > 1) {
            d2 = p.charAt(1);
        }

        if (d2 == '*') {
            if (d1 == '.' || c1 == d1) {
                //fork here: 1. consume the character, and use the same pattern again.
                //2. keep the character, and skip 'd1*' pattern

                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (d1 == '.' || c1 == d1) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    public boolean checkEmpty(String p) {

        //if String P is Empty, it should be either: length = 0, or in format pattern as a*a*a*a*a*...a* (a can be refer to any char)

        if (p.length() % 2 != 0) {
            return false;
        }

        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }

}
