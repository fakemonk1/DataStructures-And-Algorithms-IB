package stacksandqueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/redundant-braces/
 * Write a program to validate if the input string has redundant braces?
 * Return 0/1
 * 0 -> NO 1 -> YES
 * <p>
 * Input will be always a valid expression
 * <p>
 * and operators allowed are only + , * , - , /
 * <p>
 * Example:
 * <p>
 * ((a + b)) has redundant braces so answer will be 1
 * (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */

public class RedundantBraces {
    public int braces(String a) {

        if (a == null || a.equals("") || a.equals(" ")) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (Character ch : a.toCharArray()) {
            if (getOperators().contains(ch) || getStartBraces().contains(ch)) {
                stack.add(ch);
            } else if (ch.equals(')')) {
                boolean inside = false;
                while (true) {
                    Character pop = stack.pop();
                    if (getOperators().contains(pop)) {
                        inside = true;
                    } else if (pop.equals('(')) {
                        if (!inside) {
                            return 1;
                        } else {
                            break;
                        }
                    }
                }
            } else if (ch.equals('}')) {
                boolean inside = false;
                while (true) {
                    Character pop = stack.pop();
                    if (getOperators().contains(pop)) {
                        inside = true;
                    } else if (pop.equals('{')) {
                        if (!inside) {
                            return 1;
                        } else {
                            break;
                        }
                    }
                }
            } else if (ch.equals(']')) {
                boolean inside = false;
                while (true) {
                    Character pop = stack.pop();
                    if (getOperators().contains(pop)) {
                        inside = true;
                    } else if (pop.equals('[')) {
                        if (!inside) {
                            return 1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return 0;
    }


    public static List<Character> getOperators() {
        return Arrays.asList('+', '-', '*', '/');
    }

    public static List<Character> getStartBraces() {
        return Arrays.asList('(', '{', '[');
    }

    public static void main(String[] args) {
        System.out.println(new RedundantBraces().braces(" "));
    }
}