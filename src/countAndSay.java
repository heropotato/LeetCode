/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/1/13
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class countAndSay {

    /*
    *
    * Count and Say
    *
    * The count-and-say sequence is the sequence of integers beginning as follows:
    *
    * 1, 11, 21, 1211, 111221, ...
    * 1 is read off as "one 1" or 11.
    * 11 is read off as "two 1s" or 21.
    * 21 is read off as "one 2, then one 1" or 1211.
    *
    * Given an integer n, generate the nth sequence.
    *
    * */

    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n < 2) return n==0?null:"1";

        StringBuilder builder = new StringBuilder();
        String prev = countAndSay(n - 1);
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            while (i + count<prev.length() && prev.charAt(i + count) == prev.charAt(i)) count++;
            i += count-1;
            builder.append(count).append(prev.charAt(i));
        }
        return builder.toString();
    }
}
