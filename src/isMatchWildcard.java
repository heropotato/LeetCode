/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/3/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class isMatchWildcard {

    /*
    *
    * Wildcard Matching
    *
    * Implement wildcard pattern matching with support for '?' and '*'.
    *
    * '?' Matches any single character.
    * '*' Matches any sequence of characters (including the empty sequence).
    *
    * The matching should cover the entire input string (not partial).
    *
    * The function prototype should be:
    * bool isMatch(const char *s, const char *p)
    *
    * Some examples:
    * isMatch("aa","a") ? false
    * isMatch("aa","aa") ? true
    * isMatch("aaa","aa") ? false
    * isMatch("aa", "*") ? true
    * isMatch("aa", "a*") ? true
    * isMatch("ab", "?*") ? true
    * isMatch("aab", "c*a*b") ? false
    *
    *
    * */

  /*

    //recursive version, failed in large set tests.

    public static boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (p.length() == 0) return s.length() == 0;

        int atLeastLength = 0;
        StringBuffer removeDuplicateStar = new StringBuffer();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*' && p.charAt(i) != '?') atLeastLength++;
            if (i > 0 && p.charAt(i - 1) == '*' && p.charAt(i) == '*') continue;
            removeDuplicateStar.append(p.charAt(i));
        }
        if (atLeastLength > s.length()) return false;
        p = removeDuplicateStar.toString();

        return isMatchHelper(s, p);

    }

    private static boolean isMatchHelper(String s, String p) {
        if (s.equalsIgnoreCase(p)) return true;
        if (p.length() == 0) return s.length() == 0;

        int i = 0;
        while (i < s.length() && i < p.length()) {
            if (p.charAt(i) != '*' && p.charAt(i) != '?') {
                if (p.charAt(i) != s.charAt(i)) return false;
                i++;
                continue;
            }
            p = p.substring(i);
            s = s.substring(i);
            break;
        }

        i = p.length() - 1;
        int j = s.length() - 1;
        while (i >= 0 && j >= 0) {
            if (p.charAt(i) != '*' && p.charAt(i) != '?') {
                if (p.charAt(i) != s.charAt(j)) return false;
                i--;
                j--;
                continue;
            }
            p = p.substring(0, i + 1);
            s = s.substring(0, j + 1);
            break;
        }

        i = 0;
        while (i < s.length()) {
            if (i == p.length()) return false;
            if (s.charAt(i) != p.charAt(i)) {
                if (p.charAt(i) != '?' && p.charAt(i) != '*') {
                    return false;
                } else if (p.charAt(i) == '?') {
                    return isMatchHelper(s.substring(i + 1), p.substring(i + 1));
                } else {
                    return (isMatchHelper(s.substring(i), p.substring(i + 1)) || isMatchHelper(s.substring(i + 1), p.substring(i)));
                }
            }
            i++;
        }
        while (i < p.length()) {
            if (p.charAt(i) != '*') return false;
            i++;
        }
        return true;
    }
*/

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int atLeastLength = 0;
        /*StringBuffer removeDuplicateStar = new StringBuffer();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*' && p.charAt(i) != '?') atLeastLength++;
            if (i > 0 && p.charAt(i - 1) == '*' && p.charAt(i) == '*') continue;
            removeDuplicateStar.append(p.charAt(i));
        }
        if (atLeastLength > s.length()) return false;
        p = removeDuplicateStar.toString();*/
        String[] splitP = p.split("\\*");
        StringBuffer removeDuplicateStar = new StringBuffer();
        if (p.charAt(0) == '*') removeDuplicateStar.append('*');
        for (String split : splitP) {
            if (split.length() > 0) removeDuplicateStar.append('*').append(split);
        }
        p = removeDuplicateStar.toString();

        boolean[] matches = new boolean[s.length() + 1];
        matches[0] = true;
        int pid = 0, firstMatch = 0;
        while (pid < p.length()) {
            // if '*', fill up the rest of row
            if (p.charAt(pid) == '*') {
                // fill up the rest of row with true, up to the first match in previous row
                for (int i = firstMatch + 1; i <= s.length(); i++) matches[i] = true;
            } else {
                // fill up backwards:
                // - set to true if match current char and previous diagnal also match
                // - otherwise, set to false
                int match = -1;
                for (int i = s.length(); i > firstMatch; i--) {
                    matches[i] = (p.charAt(pid) == s.charAt(i - 1) || p.charAt(pid) == '?')
                            && matches[i - 1];
                    if (matches[i]) match = i;
                }
                if (match < 0) return false;
                firstMatch = match;
            }
            pid++;
        }
        return matches[s.length()];
    }


}
