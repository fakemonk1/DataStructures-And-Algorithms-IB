package strings;

/**
 * https://www.interviewbit.com/problems/implement-strstr/
 *
 * Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


 */
public class ImplementStrStr {

    //Naive Algo - O(mn) , O(m+n) with KMP algorithm
    //TODO: implement KMP as well
    public static int strStr(final String haystack, final String needle) {

        if (needle.length() == 0 || haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }
        int answer = -2;

        for (int i = 0; i < haystack.length(); i++) {
            boolean found = true;
            int needleIndex = 0;
            int hIndex = i;

            while (hIndex <= haystack.length() - 1 && needleIndex <= needle.length() - 1) {
                if (!(haystack.charAt(hIndex) == needle.charAt(needleIndex))) {
                    found = false;
                    break;
                } else {
                    hIndex++;
                    needleIndex++;
                    continue;
                }
            }
            if (found && needleIndex ==  needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaststs", "str"));
    }
}
