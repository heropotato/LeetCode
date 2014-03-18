/**
 * Created by yongwen on 3/18/14.
 */
public class reverseWords {

    /*
    *
    * Reverse Words in a String
    *
    * Given an input string, reverse the string word by word.
    *
    * For example,
    * Given s = "the sky is blue",
    * return "blue is sky the".
    *
    * click to show clarification.
    *
    * */

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder builder = new StringBuilder("");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].trim().isEmpty()) builder.append(split[i].trim()).append(" ");
        }
        return builder.toString().trim();
    }
}
