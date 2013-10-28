import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class minCut {

    /*
    *
    * Palindrome Partitioning II
    *
    *
    * Given a string s, partition s such that every substring of the partition is a palindrome.
    *
    * Return the minimum cuts needed for a palindrome partitioning of s.
    *
    * For example, given s = "aab",
    * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
    *
    *
    * */

    public static int minCut(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // DP solution:
        // DP for both isPalindrome checking and minCut calculating
        // save all substring isPalindrome result in a Boolean[s.length()][s.length()] board
        // e.g. start = 1, end = 2, then isPalindrome(s.substring(1, 2+1)) = board[1][2];
        // check minCut from 0 to i in the given string

        int[] res = new int[s.length()];

        Boolean[][] board = new Boolean[s.length()][s.length()];
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end) && (end - start < 2 || board[start + 1][end - 1])) {
                    board[start][end] = true;
                } else {
                    board[start][end] = false;
                }
            }
        }

        for (int end = 0; end < s.length(); end++) {
            int curLength = s.length();
            if (board[0][end]) res[end] = 0;
            else {
                for (int start = 0; start < end; start++) {
                    if (board[start + 1][end] && curLength > res[start] + 1) {
                        curLength = res[start] + 1;
                    }
                }
                res[end] = curLength;
            }
        }
        return res[s.length() - 1];
    }
}
