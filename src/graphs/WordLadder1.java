package ds.graphs;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/word-ladder-i/
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 You must change exactly one character in every transformation
 Each intermediate word must exist in the dictionary
 Example :

 Given:

 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note that we account for the length of the transformation path instead of the number of transformation itself.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadder1 {

    public int findMinHops(String startWord, String endWord, List<String> dict) {

        Queue<QueueEntry> queue = new LinkedList<>();
        QueueEntry entry = new QueueEntry(startWord, 1);
        queue.add(entry);
        QueueEntry polled = entry;
        boolean found = false;
        while (!queue.isEmpty()) {
            polled = queue.poll();
            if (polled.word.equals(endWord)) {
                found  = true;
                break;
            }
            Iterator<String> iterator = dict.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                if (isadjacent(str, polled.word)) {
                    queue.add(new QueueEntry(str, polled.hops + 1));
                    iterator.remove();
                }
            }
        }
        if(!found){
            return 0;
        }
        return polled.hops;
    }

    public boolean isadjacent(String a, String b) {
        int count = 0;  // to store count of differences

        // Iterate through all characters and return false
        // if there are more than one mismatching characters
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        return count == 1;
    }

    static class QueueEntry {
        String word;
        int hops;

        public QueueEntry(String word, int hops) {
            this.word = word;
            this.hops = hops;
        }
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.addAll(Arrays.asList("xx"));
        System.out.println(new WordLadder1().findMinHops("aa", "bb", dict));
    }
}
