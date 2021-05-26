class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l = atn.addTwoNumbers(l1, l2);
        System.out.println(l.toString());
        System.out.println();

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l2 = new ListNode(9);
        l2.next = new ListNode(7);
        l = atn.addTwoNumbers(l1, l2);
        System.out.println(l.toString());
        System.out.println();
    }
}


//01
//1568 / 1568 test cases passed.
// Status: Accepted
// Runtime: 2 ms
// Memory Usage: 39.2 MB
