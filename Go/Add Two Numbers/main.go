/*
https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

//#2
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var resultNode, lastAdded *ListNode
	currentL1 := l1
	currentL2 := l2
	reaminingValue := 0

	valOrZeroFn := func(node *ListNode) int {
		if node == nil {
			return 0
		}
		return node.Val
	}

	for {
		if currentL1 == nil && currentL2 == nil && reaminingValue == 0 {
			break
		}

		value := valOrZeroFn(currentL1) + valOrZeroFn(currentL2) + reaminingValue
		if value >= 10 {
			value = value - 10
			reaminingValue = 1
		} else {
			reaminingValue = 0
		}

		if resultNode == nil {
			resultNode = &ListNode{Val: value}
			lastAdded = resultNode

		} else {
			newNode := &ListNode{Val: value}
			lastAdded.Next = newNode
			lastAdded = newNode
		}

		if currentL1 != nil {
			currentL1 = currentL1.Next
		}

		if currentL2 != nil {
			currentL2 = currentL2.Next
		}

	}

	return resultNode
}

//#1
func addTwoNumbers1(l1 *ListNode, l2 *ListNode) *ListNode {
	cur := new(ListNode)
	ret := cur
	sum := 0
	for l1 != nil || l2 != nil {
		if l1 != nil {
			sum = sum + l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum = sum + l2.Val
			l2 = l2.Next
		}

		cur.Next = &ListNode{
			sum % 10,
			nil,
		}
		cur = cur.Next
		sum = sum / 10
	}

	if sum > 0 {
		cur.Next = &ListNode{sum, nil}
	}

	return ret.Next
}

//#0
//Has issues
func addTwoNumbers0(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}

	if l2 == nil {
		return l1
	}

	n1, n2, n := l1.Val, l2.Val, 10

	for l1.Next != nil {
		n1 = n1 + l1.Next.Val*n
		l1 = l1.Next
		n = n * 10
	}

	n = 10
	for l2.Next != nil {
		n2 = n2 + l2.Next.Val*n
		l2 = l2.Next
		n = n * 10
	}

	n = n1 + n2
	//fmt.Println("n:", n)

	if n == 0 {
		return &ListNode{Val: 0}
	}

	head := &ListNode{Val: 0}
	l := head
	for n > 0 {
		//fmt.Println("n:", n, "; n%%10:", n%10, "; n/10:", n/10)
		l.Next = &ListNode{Val: n % 10}
		l = l.Next
		n = n / 10
	}

	return head.Next
}

func print(l *ListNode) {
	if l == nil {
		fmt.Println("It is nil")
		return
	}

	fmt.Print(l.Val)
	for l.Next != nil {
		fmt.Print(l.Next.Val)
		l = l.Next
	}
	fmt.Println()
}

func main() {
	l1 := &ListNode{Val: 7}
	l2 := &ListNode{Val: 9}
	l := addTwoNumbers(l1, l2)
	print(l)

	l1 = &ListNode{Val: 0}
	l2 = &ListNode{Val: 0}
	l = addTwoNumbers(l1, l2)
	print(l)
}

// Input:
// [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
// [5,6,4]
// Output:
// [2,8,0,4,6,2,5,0,3,0,7,2,4,4,9,6,7,0,5]
// Expected:
// [6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]

//1568 / 1568 test cases passed.
// Status: Accepted
// Runtime: 12 ms
// Memory Usage: 5 MB
//
//  ==>
// Runtime: 16 ms
// Memory Usage: 5 MB
