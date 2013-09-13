/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/13/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class atoi {

    /*
    *
    * May 17, 2013
    *
    * String to Integer (atoi)
    *
    * Implement atoi to convert a string to an integer.
    *
    * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
    *
    * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
    *
    *
    * */

    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (str == null) {
            return 0;
        } else {

            String sb = new String();

            Boolean started = false;
            Boolean minus = false;

            for (Character c : str.toCharArray()) {

                if (started == false && c == '-') {

                    minus = true;
                    started = true;

                } else if (started == false && c == '+') {

                    started = true;

                } else if (started == false && Character.isLetter(c)) {

                    break;

                } else {

                    if (started == true && !Character.isDigit(c)) {

                        break;

                    } else if (started == false && Character.isDigit(c)) {

                        started = true;

                        sb += c;

                    } else if (started == true && Character.isDigit(c)) {

                        sb += c;
                    }

                }


            }

            //System.out.println("Result is: " + sb);

            if (sb.isEmpty()) {

                return 0;

            } else if (minus) {

                try {
                    return -(Integer.valueOf(sb));
                } catch (NumberFormatException ex) {
                    return Integer.MIN_VALUE;
                }

            } else {
                try {
                    return Integer.valueOf(sb);
                } catch (NumberFormatException ex) {
                    return Integer.MAX_VALUE;
                }
            }


        }


    }

}
