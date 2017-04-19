package stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(ArrayList<Integer> a) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int largest = 0;

        for (int i = 0; i < a.size(); i++) {
            int h = a.get(i);
            //new bigger
            if (stack.isEmpty() || stack.peek() < h) {
                stack.add(h);
                indexStack.add(i);
                //new smaller
            } else if (!stack.isEmpty() && stack.peek() > h) {
                int index = 0;
                while (!stack.isEmpty() && stack.peek() > h) {
                    Integer poppedHeight = stack.pop();
                    index = indexStack.pop();
                    //set largest
                    int areaOfPopped = poppedHeight * (i - index);
                    largest = areaOfPopped > largest ? areaOfPopped : largest;
                }
                stack.add(h);
                indexStack.add(index);
            }
        }
        while (!stack.isEmpty()) {
            int i = a.size();
            Integer poppedHeight = stack.pop();
            int index1 = indexStack.pop();
            //set largest
            int areaOfPopped = poppedHeight * (i - index1);
            largest = areaOfPopped > largest ? areaOfPopped : largest;
        }
        return largest;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(1);
        integers.add(1);
        integers.add(0);
        integers.add(10);
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(integers));
    }
}