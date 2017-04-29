package strings;

/**
 * https://www.interviewbit.com/problems/length-of-last-word/
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Given s = "Hello World",

 return 5 as length("World") = 5.
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(final String a) {

        StringBuilder sb = new StringBuilder("");
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) != ' ') {
                sb.append(a.charAt(i));
            } else {
                if(sb.length()> 0)
                break;
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Lebz Q"));
    }
}
