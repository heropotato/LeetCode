import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class convert {

    /*
    *
    * May 15, 2013
    *
    * ZigZag Conversion
    *
    *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    *
    *  P   A   H   N
    *  A P L S I I G
    *  Y   I   R
    *
    * And then read line by line: "PAHNAPLSIIGYIR"
    *
    * Write the code that will take a string and make this conversion given a number of rows:
    *
    * string convert(string text, int nRows);
    *
    * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
    *
    * */

    public String convert(String s, int nRows) {
        if(s.length() < 2 || nRows == 1 || s.length() <= nRows) return s;
        StringBuilder stringBuilder = new StringBuilder("");
        int count = 0;

        // deal with base case when nRows == 2
        if (nRows == 2) {
            StringBuilder stringBuilder1 = new StringBuilder("");
            for (char c:s.toCharArray()){
                if (count%2==0) stringBuilder.append(c);
                else stringBuilder1.append(c);
                count++;
            }
            return stringBuilder.append(stringBuilder1).toString();
        }

        // deal with general cases
        ArrayList<LinkedBlockingQueue<Character>> scans = new ArrayList<LinkedBlockingQueue<Character>>();
        count = nRows;
        while (count > 0){
            LinkedBlockingQueue<Character> temp = new LinkedBlockingQueue<Character>();
            scans.add(temp);
            count--;
        }
        boolean foward = true;

        for (char c:s.toCharArray()){
            if (foward){
                scans.get(count).offer(c);
                count++;
                if (count == nRows){
                    foward = false;
                    count = nRows-2;
                }
            }else {
                scans.get(count).offer(c);
                count--;
                if (count == 0){
                    foward = true;
                }
            }
        }

        for (LinkedBlockingQueue<Character> queue:scans){
            while (!queue.isEmpty()) stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }

}
