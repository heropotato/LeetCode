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
        if (s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        String result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {

            String temp1 = resultFind(s, i, i);

            if (temp1.length() > result.length()) {
                result = temp1;
            }

            String temp2 = resultFind(s, i, i + 1);


            if (temp2.length() > result.length()) {
                result = temp2;
            }
        }

        return result;
    }

    public String resultFind(String s, int l, int r) {

        int leftStep = l;
        int rightStep = r;

        while (leftStep > -1 && rightStep < s.length() && s.charAt(leftStep) == s.charAt(rightStep)) {

            leftStep = leftStep - 1;
            rightStep = rightStep + 1;

        }

        return s.substring(leftStep + 1, rightStep);
    }
}
