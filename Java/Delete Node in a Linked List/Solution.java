
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/553/
 * 
 * Delete Node in a Linked List
 * 
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
It is guaranteed that the node to be deleted is not a tail node in the list.

Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
Example 3:
Input: head = [1,2,3,4], node = 3
Output: [1,2,4]
Example 4:
Input: head = [0,1], node = 0
Output: [1]
Example 5:
Input: head = [-3,5,-99], node = -3
Output: [5,-99]

Constraints:
The number of the nodes in the given list is in the range [2, 1000].
-1000 <= Node.val <= 1000
The value of each node in the list is unique.
The node to be deleted is in the list and is not a tail node
 * 
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution {
    // 01
    public void deleteNode(ListNode node) {
        if (node.next == null || node == null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Mine
    public void deleteNode(ListNode head, ListNode node) {
        if (node == null) {
            return;
        }

        ListNode prev = new ListNode(0, head);
        ListNode p = head;

        while (p != null) {
            if (p.val == node.val) {
                // delete at here
                prev.next = p.next;
                break;
            }
            p = p.next;
            prev = prev.next;
        }

        head = prev.next;
    }

    public void test(ListNode head, ListNode node) {
        System.out.println("--------------------------------------------------------");
        if (node == null) {
            System.out.println("The node is NULL");
        } else {
            System.out.println(String.format("Before: %s, %s", head.toString(), node.toString()));
            deleteNode(head, node);
            System.out.println(String.format("After: %s", head.toString()));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        ListNode node = new ListNode(5);
        sol.test(head, node);

        head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        node = new ListNode(1);
        sol.test(head, node);
    }
}

/*
 * 01 41 / 41 test cases passed. Status: Accepted Runtime: 0 ms Memory Usage:
 * 38.5 MB
 */

/*
 * Mine 30 / 30 test cases passed. Status: Accepted Runtime: 2 ms Memory Usage:
 * 36.5 MB Your runtime beats 72.59 % of java submissions Your memory usage
 * beats 82.62 % of java submissions.
 */
