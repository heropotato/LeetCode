import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/22/13
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class romanToInt {

    /*
    *
    * Roman to Integer
    *
    * Given a roman numeral, convert it to an integer.
    *
    * Input is guaranteed to be within the range from 1 to 3999.
    *
    *
    *
    * */

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        Hashtable<Character, Integer> romanToIntMap = new Hashtable<Character, Integer>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        int res = 0;
        int pointer = 0;

        while (pointer < s.length()) {

            char temp = s.charAt(pointer);

            if (romanToIntMap.containsKey(temp)) {

                int cur = romanToIntMap.get(temp);

                if (pointer + 1 < s.length() && (romanToIntMap.get(s.charAt(pointer + 1)) > cur)) {
                    res -= cur;
                } else {
                    res += cur;
                }

            }

            pointer++;
        }

        return res;
    }
}
