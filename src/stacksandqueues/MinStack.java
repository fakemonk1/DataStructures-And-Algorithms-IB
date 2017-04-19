package stacksandqueues;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) – Push element x onto stack.
 * pop() – Removes the element on top of the stack.
 * top() – Get the top element.
 * getMin() – Retrieve the minimum element in the stack.
 */

//TODO :  Can be further optimized a bit if we keep only one only value for the repetitive values in stack2
public class MinStack {
    private Stack<Integer> list = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
        list.clear();
        stack2.clear();
    }

    public void push(int x) {
        list.add(x);
        if (stack2.isEmpty() || stack2.peek() > x)
            stack2.add(x);
        else if (stack2.peek() < x)
            stack2.add(stack2.peek());
    }

    public void pop() {
        if (!list.isEmpty()) {
            list.pop();
            stack2.pop();
        }

    }

    public int top() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(0);
    }

    public int getMin() {
        if (list.isEmpty()) {
            return -1;
        }
        return stack2.peek();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.getMin();
    }
}
