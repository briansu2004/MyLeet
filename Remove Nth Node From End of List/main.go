/*
https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Follow up: Could you do this in one pass?

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#1
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{Next: head}
	slow, fast := dummy, dummy

	for i := 0; i <= n; i++ {
		fast = fast.Next
	}

	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}

	slow.Next = slow.Next.Next

	return dummy.Next
}

//208 / 208 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.2 MB
