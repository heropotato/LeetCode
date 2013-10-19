import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/19/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class restoreIpAddresses {

    /*
    *
    * Restore IP Addresses
    *
    * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    *
    * For example:
    * Given "25525511135",
    *
    * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
    *
    *
    *
    * */

    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() > 12 || s.length() < 4) return res;
        restoreIpAddresses(res, "", s, 0);
        return res;
    }

    private void restoreIpAddresses(ArrayList<String> res, String tempRes, String s, int count) {
        if (count == 3 && isValid(s)) {
            res.add(tempRes + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String subString = s.substring(0, i);
            if (isValid(subString))
                restoreIpAddresses(res, tempRes + subString + ".", s.substring(i), count + 1);
        }

    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
