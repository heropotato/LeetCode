import java.util.ArrayList;
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
    * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    * A partially filled sudoku which is valid.
    *
    * */

    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Character>> rows = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> cols = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> sets = new ArrayList<ArrayList<Character>>();

        for (int i = 0; i < 9; i++) {
            rows.add(new ArrayList<Character>());
            cols.add(new ArrayList<Character>());
            sets.add(new ArrayList<Character>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                rows.get(row).add(c);
                cols.get(col).add(c);
                if (row / 3 < 1) {
                    if (col / 3 < 1) sets.get(0).add(c);
                    else if (col / 3 < 2) sets.get(1).add(c);
                    else sets.get(2).add(c);
                } else if (row / 3 < 2) {
                    if (col / 3 < 1) sets.get(3).add(c);
                    else if (col / 3 < 2) sets.get(4).add(c);
                    else sets.get(5).add(c);
                } else {
                    if (col / 3 < 1) sets.get(6).add(c);
                    else if (col / 3 < 2) sets.get(7).add(c);
                    else sets.get(8).add(c);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!isValidSudoku(rows.get(i)) || !isValidSudoku(cols.get(i)) || !isValidSudoku(sets.get(i))) return false;
        }
        return true;
    }

    private boolean isValidSudoku(ArrayList<Character> set) {
        HashSet<Character> hashSet = new HashSet<Character>();
        for (Character s : set) if (s != '.' && !hashSet.add(s)) return false;
        return true;
    }
}
