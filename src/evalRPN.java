import java.util.Stack;

/**
 * Created by yongwen on 11/27/13.
 */
public class evalRPN {

    /*
    *
    * Evaluate Reverse Polish Notation
    *
    * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    *
    * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    *
    * Some examples:
    *
    * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    *
    * */

    public int evalRPN(String[] tokens) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // A straightforward one:
        // Use a stack to track all iterated numbers until the next one is a operator
        // then pop out 2 element from stack and calculate against operator
        // Hint: in case of tokens contains only one number, then return it as result.
        int res = 0;
        Stack<Integer> path = new Stack<Integer>();
        for (String token:tokens){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int tempRes = 0;
                switch (token.charAt(0)){
                    case '+': tempRes = path.pop()+path.pop();
                        break;
                    case '-': tempRes = -(path.pop()-path.pop());
                        break;
                    case '*': tempRes = path.pop()*path.pop();
                        break;
                    case '/': int temp = path.pop();
                              tempRes = path.pop()/temp;
                        break;
                }
                path.push(tempRes);
            }else {
                path.push(Integer.parseInt(token));
            }
        }

        res = path.size()==0?res:path.pop();
        return res;
    }
}
