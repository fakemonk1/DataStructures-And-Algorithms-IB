package strings;

/**
 * https://www.interviewbit.com/problems/atoi/
 *
 * Implement atoi to convert a string to an integer.
 * <p>
 * Example :
 * <p>
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
 * <p>
 * Questions:
 * Q1. Does string contain whitespace characters before the number?
 * A. Yes
 * Q2. Can the string have garbage characters after the number?
 * A. Yes. Ignore it.
 * Q3. If no numeric character is found before encountering garbage characters, what should I do?
 * A. Return 0.
 * Q4. What if the integer overflows?
 * A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 */
public class Atoi {

    public static void main(String[] args) {
        Atoi instance = new Atoi();
        int x = instance.atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3  5 14703818 776366059B9O43393");
        System.out.println("Conversion is: " + x);
    }

    public int atoi(String number1) {
        if (number1 == null || number1.trim().length() == 0) {
            return 0;
        }

        int result = 0;

        // trim the number1
        String number = number1.trim();
        boolean negate = false;
        char sign = number.charAt(0);

        if (sign == '+' || sign == '-') {
            if (sign == '-') {
                negate = true;
            }
            number = number.substring(1);
        }

        //StringBuilder sb = new StringBuilder("");
        long num = 0;
        int length = number.length();
        for (int index = 0; index < length; index++) {
            char digit = number.charAt(index);

            // sanitize the digit
            if (!(digit >= '0' && digit <= '9')) {
                break;
            }
            num = num * 10 + digit - '0';

            if (num > Integer.MAX_VALUE) {
                if (!negate)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }

        }
        // if negative, do it
        if (negate) {
            return (int)( 0l - num);
        }
        return (int) num;
    }

}