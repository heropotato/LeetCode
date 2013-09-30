import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/30/13
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class isValidSudoku {

    /*
    *
    * Valid Sudoku
    *
    * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
    *
    * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    *
    * A partially filled sudoku which is valid.
    *
    *
    * */

    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Character>> rows = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> columns = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> sets = new ArrayList<ArrayList<Character>>();

        int count = 0;
        while(count<9){
            ArrayList<Character> tempR = new ArrayList<Character>();
            ArrayList<Character> tempC = new ArrayList<Character>();
            ArrayList<Character> tempS = new ArrayList<Character>();
            rows.add(tempR);
            columns.add(tempC);
            sets.add(tempS);
            count++;
        }

        int row=0;
        while(row<9){
            int col=0;
            while (col<9){

                char c = board[row][col];
                rows.get(row).add(c);
                columns.get(col).add(c);
                if(row<3){
                    if(col<3){
                        sets.get(0).add(c);
                    }
                    if(col>=3 && col<6){
                        sets.get(1).add(c);
                    }
                    if(col>=6){
                        sets.get(2).add(c);
                    }
                }

                if(row>=3 && row<6){
                    if(col<3){
                        sets.get(3).add(c);
                    }
                    if(col>=3 && col<6){
                        sets.get(4).add(c);
                    }
                    if(col>=6){
                        sets.get(5).add(c);
                    }
                }

                if(row>=6){
                    if(col<3){
                        sets.get(6).add(c);
                    }
                    if(col>=3 && col<6){
                        sets.get(7).add(c);
                    }
                    if(col>=6){
                        sets.get(8).add(c);
                    }
                }
                col++;
            }
            row++;
        }

        count--;
        while (count>=0){
            if(!isValidSudoku(rows.get(count))){
            }
            if(!isValidSudoku(rows.get(count)) || !isValidSudoku(columns.get(count)) || !isValidSudoku(sets.get(count))){
                return false;
            }
            count--;
        }
        return true;
    }

    private boolean isValidSudoku(ArrayList<Character> set) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Character> hashSet = new HashSet<Character>();

        for(Character s:set){
            if(s=='.') continue;
            if(hashSet.contains(s)){
                return false;
            }

            hashSet.add(s);
        }

        return true;
    }

}
