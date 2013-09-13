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
    *
    * */
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function

        char[] input = s.toCharArray();

        if (nRows == 1) {

            return s;

        }


        if (nRows == 2) {

            StringBuffer firstPart = new StringBuffer();
            StringBuffer secondPart = new StringBuffer();

            for (int i = 0; i < input.length; i++) {

                if (i % 2 == 0) {
                    firstPart.append(input[i]);
                } else {
                    secondPart.append(input[i]);
                }

            }

            return firstPart.append(secondPart).toString();

        }


        if (s.length() > nRows) {

            String[] sArrays = new String[nRows];

            int oneRound = 2 * nRows - 3;

            int count = 0;

            int times = 2;

            for (int i = 0; i < s.length(); i++) {

                if (count == oneRound + 1) {

                    count = 0;
                    times = 2;

                }

                if (count > nRows - 1) {

                    sArrays[count - times] += input[i];

                    times = times + 2;

                } else {

                    if (sArrays[count] == null) {
                        sArrays[count] = String.valueOf(input[i]);
                    } else {
                        sArrays[count] += input[i];
                    }
                }

                count++;

            }

            String re = new String();


            for (String sArray : sArrays) {

                re += sArray;
            }

            return re;

        } else {

            return s;

        }


    }
}
