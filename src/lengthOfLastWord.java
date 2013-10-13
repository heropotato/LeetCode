/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/8/13
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class lengthOfLastWord {

    /*
    *
    * Length of Last Word
    *
    * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
    *
    * If the last word does not exist, return 0.
    *
    * Note: A word is defined as a character sequence consists of non-space characters only.
    *
    * For example,
    * Given s = "Hello World",
    * return 5.
    *
    *
    *
    * */

    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        boolean skip = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (skip) continue;
                break;
            }
            skip = false;
            res++;
        }
        return res;
    }
}
