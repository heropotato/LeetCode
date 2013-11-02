import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class fullJustify {

    /*
    *
    * Text Justification
    *
    * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
    *
    * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
    *
    * Extra spaces between words should be distributed as evenly as possible.
    *
    * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
    *
    * For the last line of text, it should be left justified and no extra space is inserted between words.
    *
    * For example,
    * words: ["This", "is", "an", "example", "of", "text", "justification."]
    * L: 16.
    *
    * Return the formatted lines as:
    *
    * [
    *   "This    is    an",
    *   "example  of text",
    *   "justification.  "
    * ]
    *
    * Note: Each word is guaranteed not to exceed L in length.
    *
    * */

    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if (words.length == 0) return res;

        ArrayList<String> curRow = new ArrayList<String>();
        int i = 0, currentLength = 0;
        while (i<words.length) {
            if (currentLength == 0) {
                curRow.add(words[i]);
                currentLength += words[i].length();
                i++;
                continue;
            }
            if (currentLength + words[i].length() + 1 <= L) {
                curRow.add(words[i]);
                currentLength += words[i].length() + 1;
                i++;
            } else {
                res.add(fullJustify(curRow, L - currentLength, L));
                currentLength = 0;
                curRow = new ArrayList<String>();
            }
        }
        StringBuffer lastLine = new StringBuffer("");
        for (String string:curRow){
            if (lastLine.length() == 0) lastLine.append(string);
            else lastLine.append(" ").append(string);
        }
        addPad(lastLine, L-lastLine.length());
        res.add(lastLine.toString());
        return res;
    }

    private String fullJustify(ArrayList<String> strings, int padding, int L) {

        if (strings.size() == 1){
            StringBuffer temp = new StringBuffer(strings.get(0));
            addPad(temp, L-temp.length());
            return temp.toString();
        }
        StringBuffer temp = new StringBuffer("");
        if (padding == 0) {
            for (String string : strings) {
                if (temp.length() == 0) {
                    temp.append(string);
                    continue;
                }
                temp.append(" ").append(string);
            }
        } else {
            int addPad = padding / (strings.size() - 1);
            int extraPad = padding % (strings.size() - 1);
            for (int i = 0; i < strings.size(); i++) {
                if (i==0){
                    temp.append(strings.get(i));
                    continue;
                }
                temp.append(" ");
                addPad(temp, addPad);
                if (extraPad > 0) temp.append(" ");
                temp.append(strings.get(i));
                extraPad--;
            }
        }

        return temp.toString();
    }

    private StringBuffer addPad(StringBuffer stringBuffer, int padding) {
        while (padding > 0) {
            stringBuffer.append(" ");
            padding--;
        }
        return stringBuffer;
    }

}
