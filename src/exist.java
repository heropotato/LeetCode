import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/13/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class exist {

    /*
    *
    * Word Search
    *
    * Given a 2D board and a word, find if the word exists in the grid.
    *
    * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
    *
    * For example,
    * Given board =
    *
    * [
    *   ["ABCE"],
    *   ["SFCS"],
    *   ["ADEE"]
    * ]
    *
    * word = "ABCCED", -> returns true,
    * word = "SEE", -> returns true,
    * word = "ABCB", -> returns false.
    *
    *
    * */

    public static void main(String[] args){

        //["CAA","AAA","BCD"], "AAB"
        char[][] board = new char[3][3];
        char[] row0 = {'C','A','A'};
        char[] row1 = {'A','A','A'};
        char[] row2 = {'B','C','D'};
        board[0] =row0;
        board[1] =row1;
        board[2] =row2;

        System.out.println("Hey: " + exist(board, "AAB"));

    }

    public static boolean exist(char[][] board, String word) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        if(board.length == 0) return word.isEmpty()?true:false;
        if(word.isEmpty()) return true;

        int rowSize = board.length;
        int colSize = board[0].length;

        ArrayList<int[]> starters = new ArrayList<int[]>();

        char start = word.charAt(0);

        for (int row = 0; row<rowSize; row++){
            for (int col = 0; col< colSize; col++){
                if(board[row][col] == start){
                    int[] position = new int[2];
                    position[0] = row;
                    position[1] = col;
                    starters.add(position);
                }
            }
        }

        for (int[] position: starters){
            boolean[][] flag = new boolean[rowSize][colSize];
            flag[position[0]][position[1]] = true;
            if(exist(board, word.substring(1), flag, position[0], position[1], rowSize, colSize)) return true;
        }
        return false;

    }

    public static boolean exist(char[][] board, String word, boolean[][] flag, int currentRow, int currentCol, int rowSize, int colSize) {

        if(word.isEmpty()) return true;

        //up
        if(currentRow-1 >= 0 && !flag[currentRow-1][currentCol] && board[currentRow-1][currentCol] == word.charAt(0)){
            flag[currentRow-1][currentCol] = true;
            if(exist(board, word.substring(1), flag, currentRow-1, currentCol, rowSize, colSize)) return true;
            flag[currentRow-1][currentCol] = false;
        }

        //down
        if(currentRow+1 < rowSize && !flag[currentRow+1][currentCol] && board[currentRow+1][currentCol] == word.charAt(0)){
            flag[currentRow+1][currentCol] = true;
            if(exist(board, word.substring(1), flag, currentRow+1, currentCol, rowSize, colSize)) return true;
            flag[currentRow+1][currentCol] = false;
        }

        //left
        if(currentCol-1 >= 0 && !flag[currentRow][currentCol-1] && board[currentRow][currentCol-1] == word.charAt(0)){
            flag[currentRow][currentCol-1] = true;
            if(exist(board, word.substring(1), flag, currentRow, currentCol-1, rowSize, colSize)) return true;
            flag[currentRow][currentCol-1] = false;
        }

        //right
        if(currentCol+1 < colSize && !flag[currentRow][currentCol+1] && board[currentRow][currentCol+1] == word.charAt(0)){
            flag[currentRow][currentCol+1] = true;
            if(exist(board, word.substring(1), flag, currentRow, currentCol+1, rowSize, colSize)) return true;
            flag[currentRow][currentCol+1] = false;
        }

        return false;
    }

 }
