package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 * <p>
 * Example
 * <p>
 * Given [1, 2, 3, 4]
 * <p>
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 * NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {

    public static List<Integer> wave(List<Integer> a) {
        if (a.size() < 1)
            return a;
        Collections.sort(a);
        int i = 0;
        while (i <= a.size() - 2) {
            Integer temp = a.get(i);
            a.set(i, a.get(i + 1));
            a.set(i + 1, temp);
            i += 2;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(wave(Arrays.asList(1, 2, 3, 4)));
    }
}
