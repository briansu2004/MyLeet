/*
https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
Merge Two Sorted Lists

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#2
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	headNode := &ListNode{Val: 0}
	currNode := headNode

	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			currNode.Next = l1
			currNode = currNode.Next
			l1 = l1.Next
		} else {
			currNode.Next = l2
			currNode = currNode.Next
			l2 = l2.Next
		}
	}
	if l2 == nil {
		currNode.Next = l1
	}
	if l1 == nil {
		currNode.Next = l2
	}
	return headNode.Next
}

//#1
func mergeTwoLists1(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2

	}
	if l2 == nil {
		return l1
	}

	var retList *ListNode
	if l1.Val < l2.Val {
		retList = l1
		l1 = l1.Next
	} else {
		retList = l2
		l2 = l2.Next
	}
	pList := retList
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			pList.Next = l1
			l1 = l1.Next
		} else {
			pList.Next = l2
			l2 = l2.Next
		}
		pList = pList.Next
	}
	if l1 == nil {
		pList.Next = l2
	} else if l2 == nil {
		pList.Next = l1
	}
	return retList
}

//#0
func mergeTwoLists0(l1 *ListNode, l2 *ListNode) *ListNode {
	l := &ListNode{Val: 0}
	head := l

	for l1.Next != nil && l2.Next != nil {
		if l1.Val > l2.Val {
			l.Next = l2
			l = l.Next
			l2 = l2.Next
		} else if l1.Val < l2.Val {
			l.Next = l1
			l = l.Next
			l1 = l1.Next
		} else {
			l.Next = l1
			l = l.Next
			l.Next = l2
			l = l.Next
			l1, l2 = l1.Next, l2.Next
		}
	}

	if l1 == nil {
		l.Next = l2
	} else if l2 == nil {
		l.Next = l1
	}

	return head.Next
}

//208 / 208 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.5 MB
//
// =>
//Runtime: 0 ms
//Memory Usage: 2.5 MB
