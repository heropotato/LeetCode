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
    * */

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        String digit[] = new String[]{"", "I","II","III","IV", "V","VI","VII","VIII","IX"};
        String digit10[] = new String[]{"", "X","XX","XXX","XL","L","LX","LXX", "LXXX","XC"};
        String digit100[] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String digit1000[]= new String[] {"", "M", "MM", "MMM"};

        int res = 0;
        int pointer = 0;

        while(pointer<s.length()){

            if()

        }

        return res;
    }

 }
