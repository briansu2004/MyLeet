/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/
Populating Next Right Pointers in Each Node II

Given a binary tree
	struct Node {
	int val;
	Node *left;
	Node *right;
	Node *next;
	}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Follow up:
You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Example 1:
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Constraints:
The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100
*/

package main

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

//#2
func subConnect(root *Node, depth int, dict map[int]*Node) {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return
	}
	if root.Right != nil {
		root.Right.Next = dict[depth]
		dict[depth] = root.Right
		if _, ok := dict[depth+1]; !ok {
			dict[depth+1] = nil
		}
		subConnect(root.Right, depth+1, dict)
	}
	if root.Left != nil {
		root.Left.Next = dict[depth]
		dict[depth] = root.Left
		if _, ok := dict[depth+1]; !ok {
			dict[depth+1] = nil
		}
		subConnect(root.Left, depth+1, dict)
	}
}

func connect(root *Node) *Node {
	dict := make(map[int]*Node)
	dict[1] = nil
	subConnect(root, 1, dict)
	return root
}

//#1
func connect1(root *Node) *Node {
	if root == nil {
		return nil
	}

	if root.Left != nil {
		if root.Right != nil {
			root.Left.Next = root.Right
		} else {
			root.Left.Next = findNext(root)
		}
	}

	if root.Right != nil {
		root.Right.Next = findNext(root)
	}

	// root.Right first
	connect(root.Right)
	connect(root.Left)

	return root
}

func findNext(node *Node) *Node {
	next := node.Next

	for next != nil {
		if next.Left != nil {
			return next.Left
		}

		if next.Right != nil {
			return next.Right
		}

		next = next.Next
	}

	return nil
}

//Copied
//55 / 55 test cases passed.
// Status: Accepted
// Runtime: 8 ms
// Memory Usage: 5.9 MB
//
// ==>
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 5.8 MB
