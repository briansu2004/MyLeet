/*
https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
Linked List Cycle II

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?
*/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

//#2
func detectCycle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	slow, fast := head, head // it needs to start at the same node
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			break
		}
	}
	if fast == nil || fast.Next == nil {
		return nil
	}
	slow = head
	for slow != fast {
		slow = slow.Next
		fast = fast.Next
	}
	return slow
}

//#1
func detectCycle1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}
	slow, fast := head.Next, head.Next.Next
	for ; fast != nil && fast.Next != nil && slow != fast; slow, fast = slow.Next, fast.Next.Next {
	}
	for slow = head; fast != nil && slow != fast; slow, fast = slow.Next, fast.Next {
	}
	return fast
}

//#0
func detectCycle0(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	n1, n2 := head, head.Next
	for n1 != n2 {
		if n2 == nil || n2.Next == nil {
			return nil
		}
		n1 = n1.Next
		n2 = n2.Next.Next

	}

	return n1
}

//16 / 16 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 3.8 MB
//
// ==>
//16 / 16 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 3.8 MB
