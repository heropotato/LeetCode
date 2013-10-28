import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class solve {

    /*
    *
    * Surrounded Regions
    *
    * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
    *
    * A region is captured by flipping all 'O's into 'X's in that surrounded region .
    *
    *
    * For example,
    * X X X X
    * X O O X
    * X X O X
    * X O X X
    * After running your function, the board should be:
    *
    *
    * X X X X
    * X X X X
    * X X X X
    * X O X X
    *
    * */

    public void solve(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (board.length < 3 || board[0].length < 3) return;
        int row = board.length, column = board[0].length;

        // BFS based solution:
        // check four edges of board first, add all 'O' on edges to the queue (those 'O' are non-flip)
        // track non-flip 'O' only
        // considering 'O' in queue, if any adjacent char is 'O', then add to the queue (because they have "way out" of the board, mark them as non-flip)
        // flip all 'O' except ones marked as non-flip

        LinkedBlockingQueue<int[]> queue = new LinkedBlockingQueue<int[]>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == column - 1) && board[i][j] == 'O') {
                    int[] position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    queue.offer(position);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int i = curPos[0], j = curPos[1];
            board[i][j] = 'N'; // n representing non-flip 'O'
            // check if any adjacent char (i-1, j) (i+1, j) (i, j-1) (i, j+1) is 'O'?
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                int[] position = new int[2];
                position[0] = i - 1;
                position[1] = j;
                queue.offer(position);
            }

            if (i + 1 < row && board[i + 1][j] == 'O') {
                int[] position = new int[2];
                position[0] = i + 1;
                position[1] = j;
                queue.offer(position);
            }

            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                int[] position = new int[2];
                position[0] = i;
                position[1] = j - 1;
                queue.offer(position);
            }

            if (j + 1 < column && board[i][j + 1] == 'O') {
                int[] position = new int[2];
                position[0] = i;
                position[1] = j + 1;
                queue.offer(position);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = board[i][j] == 'N' ? 'O' : 'X';
            }
        }

    }
}
