public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }


    // public String toString(ListNode node) {
    //     if (node == null) {
    //         return null;
    //     }

    //     StringBuilder sb = new StringBuilder();

    //     while (node.next != null) {
    //         sb.append(node.val);
    //         node = node.next;
    //     }

    //     return sb.toString();
    // }

    @Override
    public String toString() {
        ListNode node = this; //new ListNode();

        StringBuilder sb = new StringBuilder();

        sb.append(node.val);
        node = node.next;
        while (node != null) {
            sb.append("->");
            sb.append(node.val);
            node = node.next;
        }

        return sb.toString();
    }
}
