/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/26/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class isPalindromeII {

    /*
    *
    * Valid Palindrome
    *
    * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    *
    * For example,
    * "A man, a plan, a canal: Panama" is a palindrome.
    * "race a car" is not a palindrome.
    *
    *
    * Note:
    * Have you consider that the string might be empty? This is a good question to ask during an interview.
    *
    * For the purpose of this problem, we define empty string as valid palindrome.
    *
    *
    *
    * */

    public boolean isPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.isEmpty()) return true;

        int i = 0, j = s.length()-1;
        while (i<j){
            if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))){
                i++;
            }else if (!Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))){
                j--;
            }else{
                if (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

 }
