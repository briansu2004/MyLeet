/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

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
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Constraints:
The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
*/

package main

// Definition for a Node.
type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

//* Preorder Traversal: Visit the root node, then traverse the left subtree and finally traverse the right subtree.
//* Inorder Traversal: Traverse the left subtree, then visit the root node and finally traverse the right subtree.

//#3
type Stack struct {
	ns []*Node
}

func (s *Stack) Push(n *Node) {
	if n != nil {
		s.ns = append(s.ns, n)
	}
}

func (s *Stack) Pop() *Node {
	ret := s.ns[len(s.ns)-1]
	s.ns = s.ns[:len(s.ns)-1]
	return ret
}

func (s *Stack) Empty() bool {
	return len(s.ns) == 0
}

func connect(root *Node) *Node {
	s := Stack{[]*Node{}}
	pot(root, &s)
	return root
}

func pot(r *Node, s *Stack) *Node {
	if r == nil {
		return nil
	}
	if !s.Empty() {
		r.Next = s.Pop()
	}
	s.Push(pot(r.Right, s))
	s.Push(pot(r.Left, s))
	return r
}

//#2
func connect2(root *Node) *Node {
	if root == nil || root.Left == nil {
		return root
	}

	root.Left.Next = root.Right

	if root.Next != nil {
		root.Right.Next = root.Next.Left
	}
	connect(root.Left)
	connect(root.Right)

	return root
}

//#1
func connect1(root *Node) *Node {
	if root == nil {
		return nil
	}
	for dummy := root; dummy.Left != nil; dummy = dummy.Left {
		for node := dummy; node != nil; node = node.Next {
			node.Left.Next = node.Right
			if node.Next != nil {
				node.Right.Next = node.Next.Left
			}
		}
	}
	return root
}

//58 / 58 test cases passed.
// Status: Accepted
// Runtime: 8 ms
// Memory Usage: 6 MB
//
// ==>
//
