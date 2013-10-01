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
    *
    * */


    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) return new String();
        return countAndSay("1", n - 1);
    }

    private String countAndSay(String pre, int n) {
        if (n == 0) return pre;
        n--;
        StringBuffer res = new StringBuffer();
        int i = 0;

        while (i < pre.length()) {
            int runner = i + 1;
            char temp = pre.charAt(i);
            int count = 1;

            while (runner < pre.length()) {
                if (pre.charAt(runner) != temp) break;
                count++;
                runner++;
            }

            res.append(count).append(temp);
            if (count > 1) {
                if (runner == pre.length()) break;
                i = runner;
            } else {
                i++;
            }
        }

        return countAndSay(res.toString(), n);
    }
}
