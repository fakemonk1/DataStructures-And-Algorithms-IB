package ds.graphs;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

 Example :

 Given:

 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.


 */
public class WordLadder2 {

    public ArrayList<ArrayList<String>> findMinHops(String startWord, String endWord, List<String> dict) {

        ArrayList<ArrayList<String>> solutions = new ArrayList<>();

        if (startWord.equals(endWord)) {
            solutions.add(new ArrayList<>(Arrays.asList(startWord)));
        }

        Queue<QueueEntry> queue = new LinkedList<>();
        ArrayList<String> d = new ArrayList<>();
        d.add(startWord);
        QueueEntry entry = new QueueEntry(startWord, d);
        queue.add(entry);
        QueueEntry polled = entry;
        while (!queue.isEmpty()) {
            polled = queue.poll();
            if (isadjacent(polled.word, endWord)) {
                if (!solutions.isEmpty() && polled.list.size() + 1 > solutions.get(0).size()) {
                    break;
                }
                final ArrayList<String> toAdd = polled.list;
                toAdd.add(endWord);
                solutions.add(polled.list);

            } else {
                Iterator<String> iterator = dict.iterator();
                while (iterator.hasNext()) {
                    String str = iterator.next();
                    if (!polled.list.contains(str)) {
                        if (isadjacent(str, polled.word)) {
                            final ArrayList<String> newList = new ArrayList<>(polled.list);
                            newList.add(str);
                            queue.add(new QueueEntry(str, newList));
                            //iterator.remove();
                        }
                    }
                }
            }

        }

        return solutions;
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
        ArrayList<String> list = new ArrayList<>();

        public QueueEntry(String word, ArrayList<String> list) {
            this.word = word;
            this.list = list;
        }
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(new WordLadder2().findMinHops("hit", "cog", dict));
    }
}

