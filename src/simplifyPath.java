import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class simplifyPath {

    /*
    *
    * Simplify Path
    *
    * Given an absolute path for a file (Unix-style), simplify it.
    *
    * For example,
    * path = "/home/", => "/home"
    * path = "/a/./b/../../c/", => "/c"
    *
    *
    * */

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<String>();
        String[] splits = path.trim().split("/");
        for (String s : splits) {
            if (s == null || s.length() == 0 || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (stack.size() > 0) stack.pop();
            } else {
                stack.push(s);
            }
        }

        StringBuffer buf = new StringBuffer();
        while (!stack.isEmpty()) {
            buf.insert(0, stack.pop());
            buf.insert(0, "/");
        }

        return buf.length() == 0 ? "/" : buf.toString();
    }
}
