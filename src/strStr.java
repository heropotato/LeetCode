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
        if(haystack.isEmpty() && needle.isEmpty()){
            return "";
        }else if((haystack.isEmpty() && !needle.isEmpty()) || (haystack.length() < needle.length())){
            return null;
        }else if(!haystack.isEmpty() && needle.isEmpty()){
            return haystack;
        }else {

            char[] h = haystack.toCharArray();
            char[] n = needle.toCharArray();

            for(int i=0; i<haystack.length(); i++){

                if(h[i] == n[0] && (haystack.length() - i) >= needle.length()){
                    int j = 1;
                    boolean temp = true;
                    while(j<needle.length()){
                        if(h[i+j] != n[j]){
                            temp = false;
                            break;
                        }
                        j++;
                    }

                    if(temp) return haystack.substring(i);

                }
            }
        }
        return null;
    }

}
