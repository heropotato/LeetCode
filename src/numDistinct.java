/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class numDistinct {

    /*
    *
    * Distinct Subsequences
    *
    * Given a string S and a string T, count the number of distinct subsequences of T in S.
    *
    * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
    *
    * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
    *
    * Here is an example:
    * S = "rabbbit", T = "rabbit"
    *
    * Return 3.
    *
    *
    * */

    public int numDistinct(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // two dimensional DP solution
        //
        int[][] board = new int[T.length() + 1][S.length() + 1];
        board[0][0] = 1;

        for (int row = 1; row <= T.length(); row++) {
            board[row][0] = 0;
        }
        for (int column = 1; column <= S.length(); column++) {
            board[0][column] = 1;
        }

        for (int row = 1; row <= T.length(); row++) {
            for (int column = 1; column <= S.length(); column++) {
                board[row][column] = board[row][column - 1];
                if (T.charAt(row - 1) == S.charAt(column - 1)) {
                    board[row][column] += board[row - 1][column - 1];
                }
            }
        }
        return board[T.length()][S.length()];
    }

}
