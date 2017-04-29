package strings;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Example:

 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem


 */
public class PalindromeString {

    public static int isPalindrome(String a) {
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < a.length()-1; i++){
            if((a.charAt(i) >= 'a' && a.charAt(i) >= 'z' ) || (a.charAt(i) >= 'A' && a.charAt(i) >= 'Z' || (a.charAt(i) >= '0' && a.charAt(i) >= '9' )))
                sb.append(a.charAt(i));
       }

        String str = sb.toString();
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1))
                return 0;
        }

        return 1;

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        //System.out.println(isPalindrome("aba"));
    }

}

