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
        //Start typing your Java solution below
        //DO NOT write main() function

        if (p.length() == 0) return s.length() == 0;

        // Divide to two categories: next char of p is * or not
        // Divide and conquer:
        // if * represent 0 time of previous char
        // if * represent 1 time of previous char
        // ...
        // if * represent n time of previous char

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) return false;
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int i = -1;
            while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                if (isMatch(s.substring(i + 1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }
}
