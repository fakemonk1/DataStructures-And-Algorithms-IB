package stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/evaluate-expression/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateExpression {

    public int evalRPN(ArrayList<String> a) {

        List operators = Arrays.asList("+", "-", "*", "/");
        Stack<String> stack = new Stack();

        for (String str : a) {
            if (operators.contains(str)) {
                Integer int2 = Integer.valueOf(stack.pop());
                Integer int1 = Integer.valueOf(stack.pop());
                stack.add(operate(str, int1, int2).toString());
            } else {
                stack.add(str);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static Integer operate(String operator, int int1, int int2) {
        switch (operator) {
            case "+":
                return int1 + int2;
            case "-":
                return int1 - int2;
            case "*":
                return int1 * int2;
            case "/":
                return int1 / int2;
        }
        return 0;
    }



}
