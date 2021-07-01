/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/117/linked-list/839/
 * Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
   //03
   public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null)
         return null;
      PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(ListNode -> ListNode.val));
      for (ListNode node : lists) {
         if (node != null)
            minHeap.add(node);
      }
      ListNode head = null, tail = null;
      while (!minHeap.isEmpty()) {
         ListNode node = minHeap.remove();

         if (head == null) {
            head = tail = node;
         } else {
            tail.next = node;
            tail = node;
         }
         if (node.next != null) {
            minHeap.add(node.next);
         }
      }
      return head;
   }

   //02
   public ListNode mergeKLists2(ListNode[] lists) {
      if (lists.length == 0) {
         return null;
      }
      return mergeHelper(lists, 0, lists.length - 1);
   }

   public ListNode mergeHelper(ListNode[] lists, int start, int end) {
      if (start == end) {
         return lists[start];
      }
      int mid = start + (end - start) / 2;
      ListNode left = mergeHelper(lists, start, mid);
      ListNode right = mergeHelper(lists, mid + 1, end);
      return merge(left, right);
   }

   // merge two lists
   public ListNode merge(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      while (l1 != null && l2 != null) {
         if (l1.val <= l2.val) {
            cur.next = l1;
            l1 = l1.next;
         } else {
            cur.next = l2;
            l2 = l2.next;
         }
         cur = cur.next;
      }
      if (l1 == null)
         cur.next = l2;
      if (l2 == null)
         cur.next = l1;
      return dummy.next;
   }

   // 01
   public ListNode mergeKLists1(ListNode[] lists) {
      Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
         @Override
         public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
         }
      });
      ListNode head = new ListNode(0), tail = head;
      for (ListNode node : lists)
         if (node != null)
            heap.offer(node);
      while (!heap.isEmpty()) {
         tail.next = heap.poll();
         tail = tail.next;
         if (tail.next != null)
            heap.offer(tail.next);
      }
      return head.next;
   }

   public void test(ListNode[] lists, ListNode expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("mergeKLists(%s): %s", lists, mergeKLists(lists)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      ListNode[] lists = new ListNode[] {};
      ListNode expect = null;
      sol.test(lists, expect);

   }
}

/*
01
133 / 133 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 40.6 MB
*/

/*
02
133 / 133 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 40.9 MB
*/

/*
03
133 / 133 test cases passed.
Status: Accepted
Runtime: 8 ms
Memory Usage: 39 MB
Your memory usage beats 99.82 % of java submissions.
*/
