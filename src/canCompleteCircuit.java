/**
 * Created with IntelliJ IDEA.
 * User: yongwen
 * Date: 10/28/13
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class canCompleteCircuit {

    /*
    *
    * Gas Station
    *
    *
    * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
    *
    * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
    *
    * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
    *
    * Note:
    * The solution is guaranteed to be unique.
    *
    *
    *
    * */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        // a pretty straightforward solution

        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            if (canCompleteCircuit(gas, cost, i)) res = i;
        }
        return res;
    }

    private boolean canCompleteCircuit(int[] gas, int[] cost, int startIndex) {
        int leftGas = 0;
        for (int i = startIndex; i < gas.length; i++) {
            leftGas += gas[i] - cost[i];
            if (leftGas < 0) return false;
        }
        for (int i = 0; i < startIndex; i++) {
            leftGas += gas[i] - cost[i];
            if (leftGas < 0) return false;
        }
        return true;
    }
}
