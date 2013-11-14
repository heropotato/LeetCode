/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class longestPalindrome {

        /*
    *
    * May 15, 2013
    *
    * Longest Palindromic Substring
    *
    * Given a string S, find the longest palindromic substring in S.
    * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
    *
    *
    * */

    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Pretty straightforward solution:
        // If s.length() < 2, then return "" if s.isisEmpty(), otherwise return s
        // Iterate s from indexes [0, s.length-2],
        // Tricky part: for each position, we have to consider two cases: aabbcbbaa and aabbaa
        // Track the longest result, and return it

        if (s.length()<2) return s.isEmpty() ? "" : s;

        String result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String temp1 = resultFind(s, i, i);
            if (temp1.length() > result.length()) result = temp1;

            String temp2 = resultFind(s, i, i + 1);
            if (temp2.length() > result.length()) result = temp2;
        }
        return result;
    }

    public String resultFind(String s, int l, int r) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }
}
