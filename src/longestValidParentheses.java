import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/28/13
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class longestValidParentheses {

    /*
    *
    * Longest Valid Parentheses
    *
    * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    * For "(()", the longest valid parentheses substring is "()", which has length = 2.
    * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
    *
    * */

    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        Stack<Integer> validTrack = new Stack<Integer>();
        int res = 0, endOfInvalid = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                validTrack.push(i);
            } else {
                if (!validTrack.isEmpty()) {
                    validTrack.pop();
                    res = validTrack.isEmpty() ? Math.max(res, i - endOfInvalid) : Math.max(res, i - validTrack.peek());
                } else {
                    endOfInvalid = i;
                }
            }
        }
        return res;
    }

}
