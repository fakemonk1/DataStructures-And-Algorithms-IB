package bitmanipulation;

/**
 *
 https://www.interviewbit.com/problems/number-of-1-bits/

 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.

 Example:

 The 32-bit integer 11 has binary representation

 00000000000000000000000000001011
 so the function should return 3.

 Note that since Java does not have unsigned int, use long for Java


 */

public class NumberOf1Bits {


    public static int numSetBits(long A) {

        int count = 0;
        while (A > 0) {
            if ((A & 1) != 0)
                count++;
            A >>= 1;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numSetBits(7l));
    }
}
