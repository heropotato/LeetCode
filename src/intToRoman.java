/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/22/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class intToRoman {

    /*
    *
    * Integer to Roman
    *
    * Given an integer, convert it to a roman numeral.
    *
    * Input is guaranteed to be within the range from 1 to 3999.
    *
    *
    *
    * */

    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        String[] digit = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] digit10 = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] digit100 = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] digit1000 = new String[]{"", "M", "MM", "MMM"};

        StringBuffer res = new StringBuffer();

        return res.append(digit1000[num / 1000]).append(digit100[num / 100 % 10]).append(digit10[num / 10 % 10]).append(digit[num % 10]).toString();
    }
}
