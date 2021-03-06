import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/25/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class generate {

    /*
    *
    * Pascal's Triangle
    *
    * Given numRows, generate the first numRows of Pascal's triangle.
    *
    *
    * For example, given numRows = 5,
    * Return
    *
    *
    * [
    *           [1],
    *          [1,1],
    *         [1,2,1],
    *        [1,3,3,1],
    *       [1,4,6,4,1]
    * ]
    *
    * */

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i<numRows;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            if (i>0){
                for(int j=0;j<res.get(i-1).size()-1;j++){
                    temp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
                }
                temp.add(1);
            }
            res.add(temp);
        }
        return res;
    }
}
