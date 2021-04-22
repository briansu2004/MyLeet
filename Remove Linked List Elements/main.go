/*
https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []

Constraints:
The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= k <= 50
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#2
func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}
	newHead := head
	ch := newHead
	for {
		if ch == nil {
			return nil
		}
		if ch.Val == val {
			newHead = newHead.Next
			ch = ch.Next
			continue
		}
		break
	}
	for {
		if ch == nil || ch.Next == nil {
			break
		}
		if ch.Next.Val == val {
			ch.Next = ch.Next.Next
			continue
		}
		ch = ch.Next
	}
	return newHead
}

//#1
func removeElements1(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}

	var curr *ListNode = head

	for curr.Next != nil {
		if curr.Next.Val == val {
			curr.Next = curr.Next.Next
		} else {
			curr = curr.Next
		}
	}

	return map[bool]*ListNode{true: head.Next, false: head}[head.Val == val]
}

//66 / 66 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 4.7 MB
//
// ==>
// Status: Accepted
// Runtime: 8 ms
// Memory Usage: 4.7 MB
