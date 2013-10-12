import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class minDistance {

    /*
    *
    * Edit Distance
    *
    * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
    *
    * You have the following 3 operations permitted on a word:
    *
    * a) Insert a character
    * b) Delete a character
    * c) Replace a character
    *
    *
    * */

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) return Math.max(word1.length(), word2.length());

        int[][] board = new int[word1.length() + 1][word2.length() + 1];

        for (int iniRow = 0; iniRow <= word1.length(); iniRow++) {
            board[iniRow][0] = iniRow;
        }
        for (int iniCol = 0; iniCol <= word2.length(); iniCol++) {
            board[0][iniCol] = iniCol;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    board[i][j] = board[i - 1][j - 1];
                } else {
                    board[i][j] = 1 + Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]);
                }
            }
        }

        return board[word1.length()][word2.length()];
    }
}
