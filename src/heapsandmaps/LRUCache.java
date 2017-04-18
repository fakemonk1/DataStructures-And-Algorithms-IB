package heapsandmaps;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/least-recently-used-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

 Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 */
public class LRUCache {
    private int capacity;
    private LinkedList<Node> list = new LinkedList<>();
    private HashMap<Integer, Node> map = new HashMap();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        //No need to check size
        if (map.containsKey(key)) {
            //remove this node from the list and append to the head of the list
            final Node node = map.get(key);
            removeNodeAndAppendAtHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            Node old = map.get(key);
            //update value
            old.value = value;
            list.remove(old);
            list.addFirst(old);
        } else {
            //check size first, if full remove the lastNode
            ensureCapacity();
            Node newNode = new Node(key, value);
            list.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    public static class Node {
        int value;
        int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void removeNodeAndAppendAtHead(Node node) {
        list.remove(node);
        list.addFirst(node);
    }

    public void ensureCapacity() {
        if (list.size() == capacity) {
            final Node removed = list.removeLast();
            map.remove(removed.key);
        }
    }
}
