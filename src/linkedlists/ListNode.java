package linkedlists;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListNode{");
        sb.append("x=").append(val);
        sb.append('}');
        return sb.toString();
    }
}
