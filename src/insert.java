import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/8/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class insert {

    /*
    *
    * Insert Interval
    *
    * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    *
    * You may assume that the intervals were initially sorted according to their start times.
    *
    * Example 1:
    * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
    *
    * Example 2:
    * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
    *
    * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
    *
    *
    * */

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval addInterval = newInterval;
        ArrayList<Interval> res = new ArrayList<Interval>();

        for (Interval interval : intervals) {
            if (interval.end < addInterval.start) {
                res.add(interval);
            } else if (interval.start > addInterval.end) {
                res.add(addInterval);
                addInterval = interval;
            } else {
                addInterval = new Interval(Math.min(addInterval.start, interval.start), Math.max(addInterval.end, interval.end));
            }
        }

        res.add(addInterval);
        return res;
    }
}
