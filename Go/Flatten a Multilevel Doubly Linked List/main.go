/*
https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
Flatten a Multilevel Doubly Linked List

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Example 1:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation:
The multilevel linked list in the input is as follows:
After flattening the multilevel linked list it becomes:

Example 2:
Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation:
The input multilevel linked list is as follows:
  1---2---NULL
  |
  3---NULL

Example 3:
Input: head = []
Output: []

How multilevel linked list is represented in test case:
We use the multilevel linked list from Example 1 above:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
The serialization of each level is as follows:
[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]

To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
[1,2,3,4,5,6,null]
[null,null,7,8,9,10,null]
[null,11,12,null]

Merging the serialization of each level and removing trailing nulls we obtain:
[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

Constraints:
The number of Nodes will not exceed 1000.
1 <= Node.val <= 105
*/

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Prev *Node
 *     Next *Node
 *     Child *Node
 * }
 */

package main

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

func flatten(root *Node) *Node {
	cur := root
	for cur != nil {
		if cur.Child == nil {
			cur = cur.Next
			continue
		}

		next := cur.Next
		// Set relation between current and child as Next/Prev and remove child link in the object
		cur.Next = cur.Child
		cur.Next.Prev = cur
		cur.Child = nil

		p := cur.Next
		for p.Next != nil {
			p = p.Next //Go thourgh all the next in Child
		}

		// Connect last node in child with the original Next
		p.Next = next
		if next != nil {
			next.Prev = p // Set up original Next node's Prev if original node got Next
		}
	}
	return root
}

func flatten1(root *Node) *Node {
	if root == nil {
		return root
	}

	// Create a pseudoHead object to reduce the number of nil checks
	pseudoHead := &Node{0, nil, root, nil}
	var curr, prev *Node = nil, pseudoHead

	// Using a stack to iterate through the nodes, and stacks are containers that
	// follows LIFO (last in, first out)
	stack := []*Node{}
	stack = append(stack, root)

	for len(stack) > 0 {
		// Pop() from the stack
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		prev.Next = curr
		curr.Prev = prev

		// Add Next to stack, followed by the Child nodes, since a stack is LIFO,
		// our code processes a Child node (and its subsequent Next nodes) before
		// continuing through the stack.
		if curr.Next != nil {
			stack = append(stack, curr.Next)
		}
		if curr.Child != nil {
			stack = append(stack, curr.Child)
			curr.Child = nil
		}
		prev = curr
	}

	// Detach the pseudoHead from the real root.
	pseudoHead.Next.Prev = nil
	return pseudoHead.Next
}

// 26 / 26 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.7 MB
