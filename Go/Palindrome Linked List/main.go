/*
https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#3
func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}

	var count int = 1

	tail := head
	for tail.Next != nil {
		tail = tail.Next
		count++
	}

	if tail.Val != head.Val {
		return false
	}

	mid := head.Next
	for i, md := 1, count/2; i < md; i++ {
		mid = mid.Next
	}

	start := head
	findLast := func(index int) int {
		m := mid
		if count%2 != 0 {
			index--
		}

		for i := 0; i < (count/2-index) && m.Next != nil; i++ {
			m = m.Next
		}

		return m.Val
	}

	for i := 1; i <= count/2 && start != nil; i++ {
		if start.Val != findLast(i) {
			return false
		}

		start = start.Next
	}

	return true
}

//#2
func isPalindrome2(head *ListNode) bool {
	vals := make([]int, 0, 0)
	for head != nil {
		vals = append(vals, head.Val)
		head = head.Next
	}
	for i, j := 0, len(vals)-1; i < len(vals); i, j = i+1, j-1 {
		if vals[i] != vals[j] {
			return false
		}
	}
	return true
}

//#1
func isPalindrome1(head *ListNode) bool {
	if head == nil {
		return true
	}
	fast, slow := head, head

	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	if fast != nil {
		slow = slow.Next
	}

	slow = reverse(slow)
	fast = head

	for slow != nil {
		if slow.Val != fast.Val {
			return false
		}
		slow = slow.Next
		fast = fast.Next
	}
	return true
}

func reverse(head *ListNode) *ListNode {
	var prev *ListNode
	for head != nil {
		head.Next, prev, head = prev, head, head.Next
	}
	return prev
}

//85 / 85 test cases passed.
// Status: Accepted
// Runtime: 164 ms
// Memory Usage: 8.7 MB
//
// ==>
//85 / 85 test cases passed.
// Status: Accepted
// Runtime: 168 ms
// Memory Usage: 10.2 MB
//
// ==>
//Runtime: 2672 ms
//Memory Usage: 10.2 MB
