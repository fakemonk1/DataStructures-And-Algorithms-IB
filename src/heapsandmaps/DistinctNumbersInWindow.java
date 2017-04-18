package heapsandmaps;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 *You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
 Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 Note:
 - If K > N, return empty array.
 For example,
 A=[1, 2, 1, 3, 4, 3] and K = 3
 All windows of size K are

 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]

 So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersInWindow {
    HashMap<Integer, Integer> map = new HashMap<>();

    public ArrayList<Integer> dNums(List<Integer> A, int B) {
        ArrayList<Integer> solution = new ArrayList<>();
        if (B > A.size()) {
            return solution;
        }
        int i = 0;
        int end = 0;
        //insert the elements in the first window
        for (i = 0; i < B; i++) {
            insert(A.get(i));
        }

        solution.add(map.size());

        while (i <= A.size() - 1) {
            insert(A.get(i++));
            remove(A.get(end));
            //add to the solution the distinct size of the current Map
            solution.add(map.size());
            end++;
        }
        return solution;
    }


    public void insert(int value) {
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
        }
    }

    public void remove(int value) {
        if (map.containsKey(value)) {
            int times = map.get(value);
            if (times >= 2) {
                map.put(value, map.get(value) - 1);
            } else {
                map.remove(value);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 4, 3);
        new DistinctNumbersInWindow().dNums(list, 3);
    }

}
