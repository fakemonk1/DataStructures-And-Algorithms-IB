package trees;

import java.util.LinkedList;

/**
 * Created by Ashish Gupta on 03/04/17.
 */
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getSubNode(ch);
            if (child != null)
                current = child;
            else {
                current.childList.add(new TrieNode(ch));
                current = current.getSubNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.getSubNode(ch) == null)
                return false;
            else
                current = current.getSubNode(ch);
        }
        if (current.isEnd)
            return true;
        return false;
    }

    public void remove(String word) {
        if (!search(word)) {
            System.out.println(word + " does not exist in trie\n");
            return;
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getSubNode(ch);
            if (child.count == 1) {
                current.childList.remove(child);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }

    static class TrieNode {
        char content;
        boolean isEnd;
        int count;
        LinkedList<TrieNode> childList;

        public TrieNode(char c) {
            childList = new LinkedList<TrieNode>();
            isEnd = false;
            content = c;
            count = 0;
        }

        public TrieNode getSubNode(char c) {
            if (childList != null)
                for (TrieNode child : childList)
                    if (child.content == c)
                        return child;
            return null;
        }
    }


}
