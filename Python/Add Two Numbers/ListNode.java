// Definition for singly-linked list
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        // if (this == null) {
        //     return null;
        // }

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(val));
        while (this.next != null) {
            sb.append(", " + String.valueOf(this.next.val));
            next = next.next;
        }
        return sb.toString();
    }
}