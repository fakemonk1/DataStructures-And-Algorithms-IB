package heapsandmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/magician-and-chocolates/
 * <p>
 * Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.
 * <p>
 * Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.
 * <p>
 * For example,
 * <p>
 * K = 3
 * N = 2
 * A = 6 5
 * <p>
 * Return: 14
 * At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
 * At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
 * At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
 * so, total number of chocolates eaten: 6 + 5 + 3 = 14
 * <p>
 * Note: Return your answer modulo 10^9+7
 */

public class MagicianAndChocolates {
    public int nchoc(int A, ArrayList<Integer> B) {

        int MOD = (int) Math.pow(10, 9) + 7;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : B) {
            queue.add(i);
        }

        int answer = 0;
        for (int i = 0; i < A; i++) {

            int eaten = queue.poll();
            answer = ((answer % MOD) + (eaten % MOD)) % MOD;
            queue.add(eaten / 2);
        }
        return answer;
    }

}
