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

            HashMap<Character, Character> maps = new HashMap<Character, Character>();

            int tempLength = 0;

            for (int c = 1; c < s.length() - i + 1; c++) {

                char tempKey = s.substring(i, c + i).toCharArray()[c - 1];

                if (!maps.containsKey(tempKey)) {
                    maps.put(tempKey, tempKey);
                    tempLength = tempLength + 1;
                } else {
                    break;
                }

                if (tempLength > longestLength) {
                    longestLength = tempLength;
                }

            }

        }

        return longestLength;
    }
}
