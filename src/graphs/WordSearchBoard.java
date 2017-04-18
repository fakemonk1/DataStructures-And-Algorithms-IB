package graphs;

import graphs.Trie.TrieNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 * <p>
 * Example:
 * <p>
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 * boggle[][]   = {{'G','I','Z'},
 * {'U','E','K'},
 * {'Q','S','E'}};
 * isWord(str): returns true if str is present in dictionary
 * else false.
 * <p>
 * Output:  Following words of dictionary are present
 * GEEKS
 * QUIZ
 * <p>
 * <p>
 * Approach:  There are two approaches for the same.
 * 1. Searching for all the words in the matrix.
 * 2. Trie based approach where we will add all the words in the trie and will search for only words in the matrix
 */


public class WordSearchBoard {

    static Trie trie = new Trie();
    Set<Character> roots = new HashSet<>();


    private void findWords(List<String> dictionary, char[][] boggle) {
        //for each root of trie, do magic
        trie = getTrie(dictionary);
        for (TrieNode node : trie.root.childList) {
            roots.add(node.content);
        }
        traverseBoggle(boggle);

    }

    public void findWords(List<String> dictionary, List<String> board) {
        char[][] boggle = new char[board.size()][board.get(0).length()];
        for (int i = 0; i < board.size(); i++) {
            boggle[i] = board.get(i).toCharArray();
        }
        findWords(dictionary, boggle);
    }


    public void traverseBoggle(char[][] boggle) {
        for (int i = 0; i <= boggle.length - 1; i++) {
            for (int j = 0; j <= boggle[0].length - 1; j++) {
                if (roots.contains(boggle[i][j])) {
                    boolean[][] traversed = new boolean[boggle.length][boggle[0].length];
                    printWords(i, j, boggle, "", traversed);
                }
            }

        }
    }

    public Trie getTrie(List<String> dictionary) {
        Trie trie = new Trie();

        for (String str : dictionary) {
            trie.insert(str);
        }
        return trie;
    }

    public void printWords(int I, int J, char[][] boggle, String str, boolean[][] travered) {
        if (!travered[I][J]) {
            String newString = str + boggle[I][J];
            travered[I][J] = true;
            if (trie.containsPrefix(newString)) {
                if (trie.search(newString)) {
                    System.out.println(newString);
                }
                //go to the 8 8 child from the i, j
                for (int i = I - 1; i <= I + 1; i++) {
                    for (int j = J - 1; j <= J + 1; j++) {
                        if (isValidIndex(i, j, boggle)) {
                            printWords(i, j, boggle, newString, travered);
                        }
                    }
                }
            }
            travered[I][J] = false;
        } else {
            return;
        }

    }


    public boolean isValidIndex(int x, int y, char[][] input) {
        if (x < 0 || y < 0 || x > input.length - 1 || y > input[0].length - 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        char boggle[][] = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        new WordSearchBoard().findWords(Arrays.asList("GEEKS", "FOR", "QUIZ", "GO"), boggle);
    }

}
