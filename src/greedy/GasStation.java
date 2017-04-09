package greedy;

import java.util.Arrays;
import java.util.List;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
 Completing the circuit means starting at i and ending up at i again.

 * Created by Ashish Gupta on 20/03/17.
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        if (getSum(cost) > getSum(gas))
            return -1;
        int i = 0;
        return test(gas, cost, 0);
    }

    public int test(final List<Integer> gas, final List<Integer> cost, int testFor) {
        int gasTillNow = 0;
        int costTillNow = 0;
        int tested = 0;
        int i = testFor;
        for (; tested <= gas.size(); ) {
            tested++;

            gasTillNow += gas.get(i);
            costTillNow += cost.get(i);

            if (costTillNow > gasTillNow) {
                return test(gas, cost, i + 1);
            }
            if (tested == gas.size())
               break;
            if (i == gas.size() - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return testFor;
    }

    public int getSum(List<Integer> gas) {
        int sum = 0;
        for (int i : gas) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(Arrays.asList(1, 2), Arrays.asList(2, 1)));
    }

}

