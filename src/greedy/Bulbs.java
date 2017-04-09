package greedy;

import java.util.Arrays;
import java.util.List;

/**
 * N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.
 * Input : [0 1 0 1]
 Return : 4

 Explanation :
 press switch 0 : [1 0 1 0]
 press switch 1 : [1 1 0 1]
 press switch 2 : [1 1 1 0]
 press switch 3 : [1 1 1 1]

 */
public class Bulbs {

    public int findMinSwitches(List<Integer> stage) {
        if(stage.size() == 0)
            return 0;
        int toFind = 0;
        int answer = 0;
        for (int i = 0; i < stage.size(); i++) {
            if (stage.get(i) == toFind) {
                answer++;
                toFind = 1 - toFind;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Bulbs().findMinSwitches(Arrays.asList(0,1,0,1)));
    }
}
