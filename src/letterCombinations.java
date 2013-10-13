import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 9/24/13
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class letterCombinations {

    /*
    *
    * Letter Combinations of a Phone Number
    *
    * Given a digit string, return all possible letter combinations that the number could represent.
    *
    *
    *
    * */

    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            res.add("");
            return res;
        }

        for (char c : digits.toCharArray()) {
            int tempNum = Integer.valueOf(String.valueOf(c));

            if (res.size() == 0) {
                res = letterCombinations(tempNum);
            } else {

                ArrayList<String> newRes = new ArrayList<String>();

                for (String s : res) {
                    for (String n : letterCombinations(tempNum)) {
                        String temp = s + n;
                        newRes.add(temp);
                    }

                }

                res = newRes;
            }
        }

        return res;

    }

    private ArrayList<String> letterCombinations(int number) {

        ArrayList<String> temp = new ArrayList<String>();

        switch (number) {

            case 2:
                temp.add("a");
                temp.add("b");
                temp.add("c");
                return temp;

            case 3:
                temp.add("d");
                temp.add("e");
                temp.add("f");
                return temp;

            case 4:
                temp.add("g");
                temp.add("h");
                temp.add("i");
                return temp;

            case 5:
                temp.add("j");
                temp.add("k");
                temp.add("l");
                return temp;

            case 6:
                temp.add("m");
                temp.add("n");
                temp.add("o");
                return temp;

            case 7:
                temp.add("p");
                temp.add("q");
                temp.add("r");
                temp.add("s");
                return temp;

            case 8:
                temp.add("t");
                temp.add("u");
                temp.add("v");
                return temp;

            case 9:
                temp.add("w");
                temp.add("x");
                temp.add("y");
                temp.add("z");
                return temp;

            default:
                temp.add("");
                return temp;

        }

    }

}
