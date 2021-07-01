/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/117/linked-list/840/
 * Sort List

Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:
Input: head = []
Output: [] 

Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
*/

class Solution {
   //03
   public ListNode sortList(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      int n = 0;
      while (head != null) {
         head = head.next;
         n++;
      }

      for (int step = 1; step < n; step <<= 1) {
         ListNode prev = dummy;
         ListNode cur = dummy.next;
         while (cur != null) {
            ListNode left = cur;
            ListNode right = split(left, step);
            cur = split(right, step);
            prev = merge(left, right, prev);
         }
      }

      return dummy.next;
   }

   private ListNode split(ListNode head, int step) {
      if (head == null)
         return null;

      for (int i = 1; head.next != null && i < step; i++) {
         head = head.next;
      }

      ListNode right = head.next;
      head.next = null;
      return right;
   }

   private ListNode merge(ListNode left, ListNode right, ListNode prev) {
      ListNode cur = prev;
      while (left != null && right != null) {
         if (left.val < right.val) {
            cur.next = left;
            left = left.next;
         } else {
            cur.next = right;
            right = right.next;
         }
         cur = cur.next;
      }

      if (left != null)
         cur.next = left;
      else if (right != null)
         cur.next = right;
      while (cur.next != null)
         cur = cur.next;
      return cur;
   }

   //02
   public ListNode sortList2(final ListNode head) {
      if (head == null || head.next == null)
         return head;

      ListNode head1 = new ListNode(Integer.MIN_VALUE);
      ListNode head2 = new ListNode(Integer.MIN_VALUE);
      ListNode node1 = head1;
      ListNode node2 = head2;

      ListNode previousNode;
      ListNode node = head.next;

      boolean s1 = true;
      boolean s2 = true;

      while (node != null) {
         previousNode = node;
         node = node.next;

         if (previousNode.val < head.val) {
            node1.next = previousNode;
            if (s1 && node1.val > previousNode.val)
               s1 = false;
            node1 = node1.next;
         } else {
            node2.next = previousNode;
            if (s2 && node2.val > previousNode.val)
               s2 = false;
            node2 = node2.next;
         }

         previousNode.next = null;
      }
      node1 = head1.next;
      node2 = head2.next;
      head1.next = null;
      head2.next = null;

      if (!s1)
         head1 = sortList(node1);
      else
         head1 = node1;

      if (!s2)
         head2 = sortList(node2);
      else
         head2 = node2;

      node = head1;
      previousNode = null;
      while (node != null) {
         previousNode = node;
         node = node.next;
      }

      if (previousNode != null) {
         previousNode.next = head;
         head.next = head2;

         return head1;
      }

      // else
      head.next = head2;
      return head;
   }

   //01
   public ListNode sortList1(ListNode head) {
      if (head == null || head.next == null)
         return head;

      // step 1. cut the list to two halves
      ListNode prev = null, slow = head, fast = head;

      while (fast != null && fast.next != null) {
         prev = slow;
         slow = slow.next;
         fast = fast.next.next;
      }

      prev.next = null;

      // step 2. sort each half
      ListNode l1 = sortList(head);
      ListNode l2 = sortList(slow);

      // step 3. merge l1 and l2
      return merge(l1, l2);
   }

   ListNode merge(ListNode l1, ListNode l2) {
      ListNode l = new ListNode(0), p = l;

      while (l1 != null && l2 != null) {
         if (l1.val < l2.val) {
            p.next = l1;
            l1 = l1.next;
         } else {
            p.next = l2;
            l2 = l2.next;
         }
         p = p.next;
      }

      if (l1 != null)
         p.next = l1;

      if (l2 != null)
         p.next = l2;

      return l.next;
   }

   public void test(ListNode head, ListNode expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("sortList(%s): %s", head, sortList(head)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      ListNode head = new ListNode(4);
      ListNode expect = new ListNode(4);
      sol.test(head, expect);

   }
}

/*
01
28 / 28 test cases passed.
Status: Accepted
Runtime: 6 ms
Memory Usage: 47.1 MB
Your runtime beats 83.51 % of java submissions.
*/

/*
02
28 / 28 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 47 MB
Your runtime beats 100.00 % of java submissions.
*/

/*
03
28 / 28 test cases passed.
Status: Accepted
Runtime: 9 ms
Memory Usage: 43.5 MB
*/
