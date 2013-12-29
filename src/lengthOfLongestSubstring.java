import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 5/14/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class lengthOfLongestSubstring {
    /*
    * May 14, 2013
    * Longest substring without repeating characters
    *
    * Given a string, find the length of the longest substring without repeating characters.
    * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
    * For "bbbbb" the longest substring is "b", with the length of 1.
    *
    *
    * */

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int res = 0;
        ArrayList<Character> path = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {

            path.clear();
            int curLength = 0;

            for (int j = i; j < s.length(); j++) {
                char cur = s.charAt(j);
                if (path.contains(cur)) break;
                path.add(cur);
                curLength++;
            }
            if (curLength > res) res = curLength;
        }
        return res;
    }
}
