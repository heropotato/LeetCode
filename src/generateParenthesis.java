import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/25/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class generateParenthesis {

    /*
    *
    * Generate Parentheses
    *
    * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    *
    * For example, given n = 3, a solution set is:
    *
    * "((()))", "(()())", "(())()", "()(())", "()()()"
    *
    *
    * */

    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<String> res = new ArrayList<String>();
        if (n == 0) return res;

        HashSet<String> hashSet = new HashSet<String>();
        while (n > 0) {
            n--;
            String insert = "()";

            if (res.size() == 0) {
                res.add(insert);
                hashSet.add(insert);
                continue;
            }

            ArrayList<String> newAdd = new ArrayList<String>();
            for (String s : res) {

                int i = 0;
                while (i < s.length()) {
                    StringBuffer temp = new StringBuffer();
                    if (i == 0) {
                        temp.append(insert).append(s);
                        if (hashSet.add(temp.toString())) newAdd.add(temp.toString());
                        temp = new StringBuffer();
                    }
                    temp.append(s.substring(0, i + 1)).append(insert).append(s.substring(i + 1));
                    if (hashSet.add(temp.toString())) newAdd.add(temp.toString());
                    i++;
                }

            }
            res = newAdd;
        }

        return res;

    }

}
