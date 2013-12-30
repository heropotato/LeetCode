import java.lang.reflect.Array;

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

    // Naive approach
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Iterate the given string,
        // considering each position i, check longest palindrome string start from i inside out
        // in addition, consider two cases:
        // "aba", "abba"

        if (s.length() < 2) return s;
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            String case1 = longestPalindrome(s, i, i);
            if (case1.length() > result.length()) result = case1;

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                String case2 = longestPalindrome(s, i, i + 1);
                if (case2.length() > result.length()) result = case2;
            }
        }

        return result;
    }

    private String longestPalindrome(String s, int left, int right) {
        while (left - 1 >= 0 && right + 1 < s.length()) {
            if (s.charAt(left - 1) != s.charAt(right + 1)) break;
            left--;
            right++;
        }
        return s.substring(left, right + 1);
    }

/*
    // Dynamic Programming approach
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Due the naive approach will exceed time limit (runs O(n^3) time complexity),
        // Dynamic Programming approach works better (O(n^2) time complexity and O(N^2) space complexity)
        // each character is palindrome, then isPalindrome[i][i] = true;
        // then if s.charAt[i] == s.charAt[i+1], then isPalindrome[i][i+1] = true;
        // then isPalindrome[i][i + j] = (s.charAt(i + j) == s.charAt(i)) && isPalindrome[i + 1][i + j - 1];

        if (s.length() < 2) return s;
        boolean[][] board = new boolean[s.length()][s.length()];
        int[] res = {0, -1}; // use int[] track the longest palindrome substring index range

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + j >= s.length()) continue;
                if (j == 0){
                    board[i][i + j] = true; // every character is palindrome itself
                } else if (j == 1) {
                    board[i][i+j] = s.charAt(i) == s.charAt(i + j);
                    if (board[i][j] && (res[1] - res[0] < j - i)) {
                        res[0] = i;
                        res[1] = j;
                    }
                } else {
                    board[i][i + j] = (s.charAt(i + j) == s.charAt(i)) && board[i + 1][i + j - 1];
                    if (board[i][j] && (res[1] - res[0] < j - i)) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return s.substring(res[0], res[1] + 1);
    }

    */
    /*
    *
    * Manacher's algorithm
    *
    * Time complexity of finding ongest palindromic substring of given string s is O(n)
    *
    *
    * */

    /*

    public String longestPalindrome(String s) {
        char[] t = preprocess(s);
        int[] p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i) p[i] = Math.min(right - i, p[mirror]);

            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        return longestPalindromicSubstring(s, p);
    }

    public char[] preprocess(String s) {
        // constructing string
        // for example: given string "abcd"
        // after constructing: "$a#b#c#d@"
        char[] t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
        return t;
    }

    // longest palindromic substring
    public String longestPalindromicSubstring(String s, int[] p) {
        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

*/
}
