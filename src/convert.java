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
        // Start typing your Java solution below
        // DO NOT write main() function

        if (nRows == 1) return s;

        char[] input = s.toCharArray();

        if (nRows == 2) {

            StringBuffer firstRow = new StringBuffer();
            StringBuffer secondRow = new StringBuffer();

            int pos = 0;

            for (Character c : input) {
                if (pos % 2 == 0) {
                    firstRow.append(c);
                } else {
                    secondRow.append(c);
                }
                pos++;
            }
            return firstRow.append(secondRow).toString();
        }

        if (s.length() <= nRows) {
            return s;
        } else {

            int eachRoundPointer = 0;
            int pointer = 0;

            String[] rows = new String[nRows];

            while (pointer < input.length) {

                if (eachRoundPointer == 2 * nRows) {
                    eachRoundPointer = 0;
                }

                if (eachRoundPointer < nRows) {
                    if (rows[eachRoundPointer] == null) {
                        rows[eachRoundPointer] = String.valueOf(input[pointer]);
                    } else {
                        rows[eachRoundPointer] += String.valueOf(input[pointer]);
                    }
                    pointer++;
                }

                if (eachRoundPointer > nRows && eachRoundPointer != 2 * nRows - 1) {
                    if (rows[2 * nRows - eachRoundPointer - 1] == null) {
                        rows[2 * nRows - eachRoundPointer - 1] = String.valueOf(input[pointer]);
                    } else {
                        rows[2 * nRows - eachRoundPointer - 1] += String.valueOf(input[pointer]);
                    }
                    pointer++;
                }

                eachRoundPointer++;

            }

            StringBuffer res = new StringBuffer();

            for (String s1 : rows) {
                res.append(s1);
            }

            return res.toString();
        }
    }
}
