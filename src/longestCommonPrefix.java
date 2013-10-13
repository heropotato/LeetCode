/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/22/13
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class longestCommonPrefix {

    /*
    *
    * Longest Common Prefix
    *
    * Write a function to find the longest common prefix string amongst an array of strings.
    *
    *
    * */

    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (strs.length == 0) return "";
        String res = strs[0];

        for (String s : strs) {

            if (s.isEmpty()) return "";
            int tempLength = Math.min(res.length(), s.length());
            int pointer = 0;

            while (pointer < tempLength) {
                if (res.charAt(pointer) != s.charAt(pointer)) break;
                pointer++;
            }

            res = res.substring(0, pointer);

        }

        return res;
    }
}
