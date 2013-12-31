import java.util.Stack;

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
    * */

    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (strs.length == 0) return "";
        Stack<String> stack = new Stack<String>();
        for (String string:strs){
            if (string.isEmpty()) return "";
            if (stack.isEmpty()) stack.push(string);
            int i = 0;
            for (; i < Math.min(stack.peek().length(), string.length()); i ++){
                if (stack.peek().charAt(i) != string.charAt(i)) break;
            }
            stack.push(stack.pop().substring(0, i));
        }
        return stack.pop();
    }
}
