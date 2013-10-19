
/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/18/13
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class numDecodings {

    /*
    *
    * Decode Ways
    *
    * A message containing letters from A-Z is being encoded to numbers using the following mapping:
    *
    * 'A' -> 1
    * 'B' -> 2
    * ...
    * 'Z' -> 26
    *
    * Given an encoded message containing digits, determine the total number of ways to decode it.
    *
    * For example,
    * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
    *
    * The number of ways decoding "12" is 2.
    *
    *
    * */

    public int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.isEmpty()) return 0;

        int[] path = new int[2];
        path[0] = 1;
        path[1] = 1;

        for(int i =0; i<s.length(); i++){
            int tempRes = 0;
            if(s.charAt(i) != '0') tempRes += path[1];
            if(i>0){
                int twoDigits = Integer.parseInt(s.substring(i-1, i+1));
                if  (s.charAt(i-1)!='0' && 0<twoDigits && twoDigits<=26) tempRes += path[0];
            }
            path[0] = path[1];
            path[1] = tempRes;
        }

        return path[1];
    }

}
