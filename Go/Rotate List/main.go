/*
https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

// 2
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}

	cur := head

	l := 1
	for cur.Next != nil {
		l++
		cur = cur.Next
	}

	k = k % l
	cur.Next = head // make it curcular

	prev := cur
	cur = head

	move := l - k
	i := 0
	for i < move {
		prev = cur
		cur = cur.Next
		i++
	}

	prev.Next = nil
	return cur
}

// 1
func rotateRight1(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}

	tail := head
	size := 1
	for tail.Next != nil {
		size++
		tail = tail.Next
	}

	// range (1, size]
	newHeadPosition := size - k%size
	if newHeadPosition == size {
		return head
	}

	newHead := head
	var last *ListNode = nil
	for i := 0; i < newHeadPosition; i++ {
		last = newHead
		newHead = newHead.Next
	}

	tail.Next = head
	last.Next = nil
	return newHead
}

// 231 / 231 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.5 MB
//
// ==>
//