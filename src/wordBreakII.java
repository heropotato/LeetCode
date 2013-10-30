import java.util.ArrayList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/29/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class wordBreakII {

    /*
    *
    * Word Break II
    *
    * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
    *
    * Return all such possible sentences.
    *
    * For example, given
    * s = "catsanddog",
    * dict = ["cat", "cats", "and", "sand", "dog"].
    *
    * A solution is ["cats and dog", "cat sand dog"].
    *
    *
    *
    * */

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // get inspired from http://www.cnblogs.com/feiling/p/3357067.html
        // two dimensional DP storing startIndex and length of a given word that existed in dict:
        // then DFS finding out proper words combinations
        ArrayList<String> res = new ArrayList<String>();
        if (s.isEmpty() || dict.isEmpty()) return res;
        boolean[][] board = new boolean[s.length()][s.length() + 1];
        for (int wordLen = 1; wordLen <= s.length(); wordLen++) {
            for (int start = 0; start <= s.length() - wordLen; start++) {
                String word = s.substring(start, start + wordLen);
                if (dict.contains(word)) {
                    board[start][wordLen] = true;
                } else {
                    for (int j = 1; j < wordLen; j++) {
                        if (board[start][j] && board[start + j][wordLen - j]) {
                            board[start][wordLen] = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!board[0][s.length()]) return res; // no possible sentences can be found.
        wordBreak(s, dict, res, board, 0, s.length(), 0, new StringBuffer(""));
        return res;
    }

    private static void wordBreak(String s, Set<String> dict, ArrayList<String> result, boolean[][] board, int start, int length, int depth, StringBuffer curSentence) {
        if (depth == length) {
            result.add(curSentence.toString().substring(0, curSentence.toString().length() - 1));
            return;
        }

        for (int len = 1; len <= length; len++) {
            if (board[start][len]) {
                String t = s.substring(start, start + len);
                if (!dict.contains(t)) continue;
                int curLen = curSentence.length();
                curSentence.append(t).append(" ");
                wordBreak(s, dict, result, board, start + len, length, start + len, curSentence);
                curSentence.delete(curLen, curSentence.length());
            }
        }
    }
}
