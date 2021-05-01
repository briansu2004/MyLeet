/*
https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/926/
N-ary Tree Postorder Traversal

Solution
Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]

Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

package main

import "container/list"

// Definition for a Node.
type Node struct {
	Val      int
	Children []*Node
}

//Postorder Traversal: Traverse the left subtree, then traverse the right subtree and finally visit the root node.

func postorder(root *Node) []int {
	res := make([]int, 0)
	visit(root, &res)
	return res
}

func visit(root *Node, res *[]int) {
	if root == nil {
		return
	}

	for _, v := range root.Children {
		visit(v, res)
	}

	*res = append(*res, root.Val)
}

func postorder1(root *Node) []int {
	res := []int{}
	if root == nil {
		return res
	}

	stack := list.New()
	stack.PushFront(root)
	for stack.Len() > 0 {
		curr := stack.Remove(stack.Front()).(*Node)
		if curr != nil {
			res = append(res, curr.Val)
		}

		for i := 0; i < len(curr.Children); i++ {
			stack.PushFront(curr.Children[i])
		}
	}

	reverse(res)

	return res
}

func reverse(s []int) {
	for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
}

//(Copied)
//Runtime: 4 ms
//Memory Usage: 4.5 MB
//Your runtime beats 41.33 % of golang submissions.
//Your memory usage beats 50.67 % of golang submissions.
//
// ==>
//Runtime: 0 ms
//Memory Usage: 4 MB
//Your runtime beats 100.00 % of golang submissions.
//Your memory usage beats 57.33 % of golang submissions.
