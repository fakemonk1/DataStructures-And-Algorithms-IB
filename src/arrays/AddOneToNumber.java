package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits,

 add 1 to the number ( increment the number represented by the digits ).

 The digits are stored such that the most significant digit is at the head of the list.

 Example:

 If the vector has [1, 2, 3]

 the returned vector should be [1, 2, 4]

 as 123 + 1 = 124
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(List<Integer> input) {
        ArrayList<Integer> answer = new ArrayList<>();

        if (input.size() <= 0) {
            answer.add(1);
            return answer;
        }

        int carry = 1;

        for (int i = input.size() - 1; i >= 0; i--) {
            int digitSum = input.get(i) + carry;
            answer.add(0, digitSum % 10);
            carry = digitSum / 10;
        }
        if (carry != 0){
            answer.add(0, carry);
        }

        //remove the preceding not required zeros
        final Iterator<Integer> iterator = answer.iterator();
        while (iterator.hasNext()){

            final Integer next = iterator.next();
            if(next == 0){
                iterator.remove();
            }else{
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new AddOneToNumber().plusOne(Arrays.asList( 0, 0, 3, 7, 6, 4, 0, 5, 5, 5)));
    }
}
