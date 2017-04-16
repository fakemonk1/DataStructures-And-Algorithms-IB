package trees;


import trees.Trie.TrieNode;
import java.util.ArrayList;
import java.util.List;

/**
 * ind shortest unique prefix to represent each word in the list.

 Example:

 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov
 */
public class ShortestUniquePrefix {

    ArrayList<String> solution1 = new ArrayList<>();

    public ArrayList<String> prefix(List<String> a) {

        Trie trie = new Trie();

        //insert all the String to the TRIE
        for (String str : a) {
            trie.insert(str);
        }

        for (String str : a) {
            TrieNode current = trie.root;
            findPrefix(str, current, "");
        }

       return solution1;
    }

    public void findPrefix(String word, TrieNode root, String wordTillNow) {
        TrieNode current  = root;
        int index = 0;

        while(true){
             current = current.getSubNode(word.charAt(index));
             if(current.count == 1){
                 solution1.add(wordTillNow+current.content);
                 break;
             }
             wordTillNow = wordTillNow+current.content;
             index++;
        }
    }

}
