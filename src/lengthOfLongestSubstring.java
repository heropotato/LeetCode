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

        int longestLength = 0;

        for (int i = 0; i < s.length(); i++) {

            ArrayList<Character> path = new ArrayList<Character>();
            int currentLength = 0;

            for (int c = i; c < s.length(); c++) {
                char current = s.charAt(c);
                if (path.contains(current)) break;
                else {
                    path.add(current);
                    currentLength++;
                }
                if (currentLength>longestLength) longestLength = currentLength;
            }

        }
        return longestLength;
    }
}
