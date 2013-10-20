/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class isInterleave {

    /*
    *
    * Interleaving String
    *
    *
    * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
    *
    * For example,
    * Given:
    * s1 = "aabcc",
    * s2 = "dbbca",
    *
    *
    * When s3 = "aadbbcbcac", return true.
    * When s3 = "aadbbbaccc", return false.
    *
    *
    *
    * */

    public static void main(String[] args){
        System.out.println(isInterleave("dbbca", "dbbca", "dbbcadbbca"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
        if (length3 != length1+length2) return false;
        if (length1 == 0) return s2.equals(s3);
        if (length2 == 0) return s1.equals(s3);

        boolean[][] board = new boolean[length1+1][length2+1];
        board[0][0] = true;

        int i = 0;
        while (i < length1 && s1.charAt(i) == s3.charAt(i)) {
            board[i+1][0] = true;
            i++;
        }

        i = 0;
        while (i < length2 && s2.charAt(i) == s3.charAt(i)) {
            board[0][i+1] = true;
            i++;
        }

        for (i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                char c = s3.charAt(i + j - 1);
                if (c == s1.charAt(i - 1)) board[i][j] = board[i - 1][j] || board[i][j];
                if (c == s2.charAt(j - 1)) board[i][j] = board[i][j - 1] || board[i][j];
            }
        }
        return board[length1][length2];
    }

}
