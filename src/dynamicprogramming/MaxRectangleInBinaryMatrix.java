package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
 * Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

 Bonus if you can solve it in O(n^2) or less.

 Example :

 A : [  1 1 1
        0 1 1
        1 0 0
     ]

 Output : 4

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

 */
public class MaxRectangleInBinaryMatrix {

    int maxTillNow = 0;

    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> previous = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int currentArea = 0;
            ArrayList<Integer> current = a.get(i);
            if (previous.isEmpty()) {
                currentArea = largestRectangleArea(current);
                previous = current;
            } else {
                currentArea = largestRectangleArea(getUpdatedList(previous, current));
                previous = current;
            }
            maxTillNow = Math.max(maxTillNow, currentArea);
        }
        return maxTillNow;
    }


    public ArrayList<Integer> getUpdatedList(ArrayList<Integer> previous, ArrayList<Integer> current) {
        for (int i = 0; i < current.size() ; i++) {
            if(current.get(i) != 0){
                current.set(i, current.get(i) + previous.get(i));
            }
        }
        return current;
    }


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
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1,1,1));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1,0,0));
        input.add(a);
        input.add(b);
        input.add(c);

        System.out.println(new MaxRectangleInBinaryMatrix().maximalRectangle(input));
    }
}


