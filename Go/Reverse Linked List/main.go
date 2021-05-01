/*
https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#2
func reverseList(head *ListNode) *ListNode {
	curr := head
	var prev *ListNode
	for curr != nil {
		tmp := curr.Next
		curr.Next = prev
		prev = curr
		curr = tmp
	}
	return prev
}

//#1
func reverseList1(head *ListNode) *ListNode {
	var front *ListNode
	mid, end := head, head
	for mid != nil {
		end = mid.Next
		mid.Next = front
		front, mid = mid, end
	}
	return front
}

//28 / 28 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.5 MB
//
// ==>
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.6 MB
