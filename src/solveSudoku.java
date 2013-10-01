import java.io.InputStreamReader;
import java.util.ArrayList;
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
    *
    * Empty cells are indicated by the character '.'.
    *
    * You may assume that there will be only one unique solution.
    *
    *
    * */

    public boolean solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        board[i][j]=k;
                        if(isValidSudoku(board, i, j) && solveSudoku(board)) return true;
                        board[i][j]='.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board, int row, int column){

        //Validate rows, columns and 3*3 sets
        HashSet<Character> existed = new HashSet<Character>();
        for(int i=0;i<9;i++){
            if(existed.contains(board[row][i])) return false;
            if(board[row][i]!='.') existed.add(board[row][i]);
        }

        existed = new HashSet<Character>();
        for(int i=0;i<9;i++){
            if(existed.contains(board[i][column])) return false;
            if(board[i][column]!='.') existed.add(board[i][column]);
        }

        existed = new HashSet<Character>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int tempRow=row/3*3+i, tempColumn=column/3*3+j;
                if(existed.contains(board[tempRow][tempColumn])) return false;
                if(board[tempRow][tempColumn]!='.') existed.add(board[tempRow][tempColumn]);
            }
        }

        return true;
    }
}
