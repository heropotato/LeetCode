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
        ArrayDeque<String> pool = new ArrayDeque<String>();
        int poolSize = 0;
        for (String word : words) {
            int pad = pool.size() == 0 ? 0 : 1;
            if (word.length() + pad + poolSize > L) {
                //pool release
                fullJustifyRelease(L, poolSize, pool, res, false);
                poolSize = word.length();
            }
            if (pool.size() == 0) {
                poolSize = word.length();
            } else {
                poolSize += 1 + word.length();
            }
            pool.offer(word);
        }
        if (!pool.isEmpty()) {
            fullJustifyRelease(L, poolSize, pool, res, true);
        }
        return res;
    }

    public void fullJustifyRelease(int L, int poolSize, ArrayDeque<String> pool, ArrayList<String> res, boolean lastLine) {

        if (lastLine) {
            StringBuffer temp = new StringBuffer("");
            while (!pool.isEmpty()) {
                if (temp.length() != 0) temp.append(" ");
                temp.append(pool.poll());
            }
            if (L - temp.length() > 0) temp.append(String.format("%1$" + (L - temp.length()) + "s", ""));
            res.add(temp.toString());
            return;
        }
        int spaceLots = pool.size() - 1;
        int spaces = L - (poolSize - spaceLots);
        StringBuffer temp = new StringBuffer("");
        if (spaceLots == 0) {
            temp.append(pool.poll());
            if (L - temp.length() > 0) temp.append(String.format("%1$" + (L - temp.length()) + "s", ""));
            res.add(temp.toString());
        } else {
            int times = spaces / spaceLots;
            if (spaces % spaceLots == 0) {
                while (!pool.isEmpty()) {
                    if (temp.length() == 0) {
                        temp.append(pool.poll());
                        continue;
                    }
                    temp.append(String.format("%1$" + times + "s", ""));
                    temp.append(pool.poll());
                }
                res.add(temp.toString());
            } else {
                int extraSpaces = spaces % spaceLots;
                while (!pool.isEmpty()) {
                    if (temp.length() == 0) {
                        temp.append(pool.poll());
                        continue;
                    }
                    temp.append(String.format("%1$" + times + "s", ""));
                    if (extraSpaces > 0) {
                        temp.append(" ");
                        extraSpaces--;
                    }
                    temp.append(pool.poll());
                }
                res.add(temp.toString());
            }
        }
    }
}
