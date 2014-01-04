import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/30/13
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class solveSudoku {

    /*
    *
    * Sudoku Solver
    *
    * Write a program to solve a Sudoku puzzle by filling the empty cells.
    * Empty cells are indicated by the character '.'.
    * You may assume that there will be only one unique solution.
    *
    * */

    public boolean solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // Basic back-trace solution
        // Scan each cell, if it is '.', then try to fill with a number from 1 to 9
        // for each try, if current try is valid and rest of the board can be solved, then it is a solution
        // otherwise, undo the current try
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (isValidSudoku(board, i, j) && solveSudoku(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board, int r, int c) {
        //Validate rows, columns and 3*3 sets
        HashSet<Character> rSet = new HashSet<Character>();
        HashSet<Character> cSet = new HashSet<Character>();
        for (int i = 0; i < 9; i++){
            if (rSet.contains(board[r][i]) || cSet.contains(board[i][c])) return false;
            if (board[r][i] != '.') rSet.add(board[r][i]);
            if (board[i][c] != '.') cSet.add(board[i][c]);
        }

        rSet = new HashSet<Character>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int setR = r / 3 * 3 + i, setC = c / 3 * 3 + j;
                if (rSet.contains(board[setR][setC])) return false;
                if (board[setR][setC] != '.') rSet.add(board[setR][setC]);
            }
        }
        return true;
    }
}
