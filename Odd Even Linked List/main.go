/*
https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

Constraints:
The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106

Follow up: Could you solve it in O(1) space complexity and O(nodes) time complexity?
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#2
func oddEvenList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil || head.Next.Next == nil {
		return head
	}

	var odd, even, next = head, head.Next, head.Next
	for odd.Next != nil && even.Next != nil {
		odd.Next = odd.Next.Next
		even.Next = even.Next.Next
		odd = odd.Next
		even = even.Next
	}
	odd.Next = next
	return head
}

//#1
func oddEvenList1(head *ListNode) *ListNode {
	// if head == nil || head.Next == nil || head.Next.Next == nil {
	// 	return head
	// }

	if head == nil {
		return head
	}
	if head.Next == nil {
		return head
	}
	if head.Next.Next == nil {
		return head
	}

	even, slow := head, head
	odd, fast := head.Next, head.Next

	for (slow != nil && slow.Next != nil && slow.Next.Next != nil) ||
		(fast != nil && fast.Next != nil && fast.Next.Next != nil) {

		slow.Next = slow.Next.Next
		slow = slow.Next

		fast.Next = fast.Next.Next
		fast = fast.Next
	}
	slow.Next = odd

	return even
}

//70 / 70 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 3.3 MB
