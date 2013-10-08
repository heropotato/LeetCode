import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/8/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class merge {

    /*
    *
    * Merge Intervals
    *
    * Given a collection of intervals, merge all overlapping intervals.
    *
    * For example,
    * Given [1,3],[2,6],[8,10],[15,18],
    * return [1,6],[8,10],[15,18].
    *
    *
    * */

    public static void main(String[] args) {
        Interval test = new Interval(2, 4);
        Interval test2 = new Interval(5, 5);
        ArrayList<Interval> tests = new ArrayList<Interval>();
        tests.add(test);
        tests.add(test2);
        Interval res = merge(tests).get(1);
        System.out.println(res.start + " and " + res.end);
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeSet<Double> trackSet = new TreeSet<Double>();
        //HashSet<Double> trackSet = new HashSet<Double>();
        for (Interval interval : intervals) {
            double head = interval.start;
            double tail = interval.end;
            while (head <= tail) {
                trackSet.add(head);
                head += 0.5;
            }
        }
        ArrayList<Interval> res = new ArrayList<Interval>();
        Double[] tempInterval = new Double[2];
        tempInterval[0] = -1.0;
        tempInterval[1] = -1.0;
        int i = 0;
        for (Double d : trackSet) {
            if (tempInterval[0] == -1.0) {
                tempInterval[0] = d;
                tempInterval[1] = d;
                i++;
                continue;
            }
            if (d - tempInterval[1] == 0.5) {
                tempInterval[1] = d;
                if (i == trackSet.size() - 1) {
                    Interval temp = new Interval(tempInterval[0].intValue(), d.intValue());
                    res.add(temp);
                }
            } else {
                Interval temp = new Interval(tempInterval[0].intValue(), tempInterval[1].intValue());
                res.add(temp);
                tempInterval[0] = d;
                tempInterval[1] = d;
                if (i == trackSet.size() - 1) {
                    Interval t = new Interval(tempInterval[0].intValue(), tempInterval[1].intValue());
                    res.add(t);
                }
            }
            i++;
        }
        return res;
    }
}
