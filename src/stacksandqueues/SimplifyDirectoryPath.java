package stacksandqueues;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/simplify-directory-path/
 *
 * Given an absolute path for a file (Unix-style), simplify it.

 Examples:

 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 Note that absolute path always begin with ‘/’ ( root directory )
 Path will not have whitespace characters.

 Solution:
 For more understanding of unix commands see:
 https://unix.stackexchange.com/questions/125522/path-syntax-rules


'.' ==> 'right here in the current directory'. It means no change.
 '..' ==> go back by one if possible

 */
public class SimplifyDirectoryPath {
    public String simplifyPath(String a) {

        Stack<String> stack = new Stack();
        for (String str : a.split("/")) {
            if (str.equals("") || str.equals(".")) {
                //ignore because '.' means 'right here in the current directory'. It means no change.
            } else if (str.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.add(str);
            }
        }

        // print new path
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyDirectoryPath().simplifyPath("/../"));
    }
}
