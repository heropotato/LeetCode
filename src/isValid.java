import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/25/13
 * Time: 12:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class isValid {

    /*
    *
    * Valid Parentheses
    *
    * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    *
    * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    *
    *
    * */

    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {

            switch (c) {

                case ')':
                    if (stack.empty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;

                case ']':
                    if (stack.empty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;

                case '}':
                    if (stack.empty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;

                default:
                    stack.push(c);
                    break;

            }

        }

        return stack.empty() ? true : false;
    }

}
