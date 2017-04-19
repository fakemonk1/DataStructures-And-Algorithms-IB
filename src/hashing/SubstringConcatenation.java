package hashing;


import java.util.*;

/**
 * https://www.interviewbit.com/problems/substring-concatenation/
 *
 * You are given a string, S, and a list of words, L, that are all of the same length.

 Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

 Example :

 S: "barfoothefoobarman"
 L: ["foo", "bar"]
 You should return the indices: [0,9].
 (order does not matter).
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> indexes = new ArrayList<>();
        if (b.size() == 0) {
            return indexes;
        }
        //if size  is lesser return null
        if (a.length() < (b.get(0).length() * b.size())) {
            return indexes;
        }
        HashSet<String> set = getHashSet(b);

        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                String test = a.substring(i, j);
              //  System.out.println("testng for: "+ test);
                if (set.contains(test)) {
                    indexes.add(i);
                }
            }
        }
        return indexes;

    }

    public HashSet<String> getHashSet(final List<String> b) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> perms = getAllPermutations(new ArrayList<>(b));
        for (String per : perms) {
            set.add(per);
        }
        return set;
    }

    public ArrayList<String> getAllPermutations(final ArrayList<String> b) {
        ArrayList<String> thisInstanceAnswer = new ArrayList<>();
        if (b.size() == 1) {
            return b;
        }

        for (Iterator iterator = b.iterator(); iterator.hasNext(); ) {
            String str = (String) iterator.next();
            ArrayList<String> cnew = new ArrayList(b);
            cnew.remove(str);
            List<String> allChildPermutations = getAllPermutations(cnew);
            for (String childPerm : allChildPermutations) {
                thisInstanceAnswer.add(str + childPerm);
            }
            cnew.add(str);
        }

        return thisInstanceAnswer;
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("foo");
        list.add("bar");

        System.out.println(new SubstringConcatenation().findSubstring("barfoothefoobarman",list ));
    }
}
