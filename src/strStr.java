/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/27/13
 * Time: 2:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class strStr {

    /*
    *
    * Implement strStr()
    *
    * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
    *
    * */

     public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle.isEmpty()) return haystack.isEmpty() ? "" : haystack;
        if (needle.length() > haystack.length()) return null;

        for (int i = 0; i < haystack.length(); i++){
            if (haystack.length()-i < needle.length()) break;
            if (haystack.charAt(i) == needle.charAt(0)){
                int j = 0, res = i;
                while (j < needle.length()){
                    if (haystack.charAt(res+j) == needle.charAt(j)) j++;
                    else break;
                    if (j == needle.length()) return haystack.substring(res);
                }
            }
        }
        return null;
    }
}
