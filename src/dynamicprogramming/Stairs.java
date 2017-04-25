package dynamicprogramming;

import java.util.HashMap;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Example :

 Input : 3
 Return : 3

 Stairs : [1 1 1], [1 2], [2 1]
 */
public class Stairs {

    public HashMap<Integer, Integer> steps = new HashMap();

    public int climbStairs(int a) {
        if (a <= 1)
            return 1;
        if (steps.containsKey(a))
            return steps.get(a);

        int count = climbStairs(a - 1) + climbStairs(a - 2);
        steps.put(a, count);
        return count;
    }
}


