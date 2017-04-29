package strings;

/**
 * https://www.interviewbit.com/problems/reverse-the-string/
 * Given an input string, reverse the string word by word.

 Example:

 Given s = "the sky is blue",

 return "blue is sky the".

 A sequence of non-space characters constitutes a word.
 Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public  class ReverseWords{
    public static String reverseWords(String a) {
        String str = a.trim();

        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length-1; i>= 0 ; i--) {
            if(!split[i].equals("")){
                sb.append(" ").append(split[i]);
            }

        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("fwbpudnbrozzifml osdt  ulc jsx kxorifrhubk ouhsuhf  sswz qfho dqmy  sn myq igjgip iwfcqq"));
    }
}
