package hashing;

import java.util.HashMap;


/**
 * https://www.interviewbit.com/problems/copy-list/
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

 Return a deep copy of the list.

 Example

 Given list

 1 -> 2 -> 3
 with random pointers going from

 1 -> 3
 2 -> 1
 3 -> 1

 Solution:  1. HashMap approach

 */


public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {

        HashMap<RandomListNode, RandomListNode> map = new HashMap();

        RandomListNode temp = head;
        RandomListNode head2 = new RandomListNode(head.label);
        RandomListNode prev = head2;
        map.put(head, head2);

        //make a copy and put in map
        while (temp.next != null) {
            RandomListNode nextInOrigional = temp.next;
            RandomListNode nextInCopy = new RandomListNode(nextInOrigional.label);
            prev.next = nextInCopy;
            map.put( nextInOrigional, nextInCopy);
            prev = nextInCopy;
            temp = temp.next;
        }

        //traverse through the newly made and adding randoms

        RandomListNode temp1 = head;
        //deal with current
        while (temp1 != null) {
            map.get(temp1).random = map.get(temp1.random);
            temp1 = temp1.next;
        }

        return head2;
    }
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

    }


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node1;

        System.out.println(node1);
        System.out.println(new CopyList().copyRandomList(node1));
    }


}
