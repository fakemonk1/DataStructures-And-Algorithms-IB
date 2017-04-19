package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * https://www.interviewbit.com/problems/colorful-number/
 * For Given Number N find if its COLORFUL number or not
 * Return 0/1
 * COLORFUL number:
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 * Example:
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * Output : 1
 */
public class ColorfulNumber {

    public int colorful(int A) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        while (A != 0) {
            int num = A % 10;
            numbers.add(num);
            A /= 10;
        }

        Collections.reverse(numbers);
        int n = numbers.size();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= numbers.get(k);
                }

                if (hashSet.contains(prod))
                    return 0;

                hashSet.add(prod);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(323));
    }
}
