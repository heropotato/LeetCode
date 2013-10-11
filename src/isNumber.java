/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/11/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class isNumber {

    /*
    *
    * Valid Number
    *
    * Validate if a given string is numeric.
    *
    * Some examples:
    * "0" => true
    * " 0.1 " => true
    * "abc" => false
    * "1 a" => false
    * "2e10" => true
    *
    *
    * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
    *
    *
    * */

    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        s = s.trim();
        if (s.isEmpty()) return false;

        String regularExpression = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        return s.matches(regularExpression) ? true : false;

    }

}
