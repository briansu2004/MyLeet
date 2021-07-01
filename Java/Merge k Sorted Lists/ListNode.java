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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null) {
            sb.append("; next: " + next.toString());
        }
        return sb.toString();
    }
}