package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestHasCycle(t *testing.T) {
	var n, n1, n2, n3, n4 *ListNode

	assert.Equal(t, hasCycle(n), false)

	//Input: head = [1], pos = -1
	//Output: false
	n = &ListNode{Val: 1, Next: nil}
	assert.Equal(t, hasCycle(n), false)

	//Input: head = [1,2], pos = 0
	//Output: true
	n1 = &ListNode{Val: 1, Next: nil}
	n2 = &ListNode{Val: 2, Next: n1}
	n1.Next = n2
	assert.Equal(t, hasCycle(n1), true)

	//Input: head = [3,2,0,-4], pos = 1
	//Output: true
	n1 = &ListNode{Val: 3, Next: nil}
	n2 = &ListNode{Val: 2, Next: nil}
	n3 = &ListNode{Val: 0, Next: nil}
	n4 = &ListNode{Val: -4, Next: nil}
	n1.Next = n2
	n2.Next = n3
	n3.Next = n4
	n4.Next = n2
	assert.Equal(t, hasCycle(n1), true)
}
