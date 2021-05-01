/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
Construct Binary Tree from Inorder and Postorder Traversal

Solution
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
*/

package main

import "math"

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//* Inorder Traversal: Traverse the left subtree, then visit the root node and finally traverse the right subtree.
//* Postorder Traversal: Traverse the left subtree, then traverse the right subtree and finally visit the root node.

//#2
func buildTree(inorder []int, postorder []int) *TreeNode {
	l := len(inorder)
	if l == 0 || len(postorder) != l {
		return nil
	}
	if l == 1 {
		return &TreeNode{Val: inorder[0]}
	}

	m := make(map[int]int)
	for i, v := range inorder {
		m[v] = i
	}

	var helper func(int, int) *TreeNode
	helper = func(in_left, in_right int) *TreeNode {
		if in_left > in_right {
			return nil
		}
		val := postorder[len(postorder)-1]
		postorder = postorder[:len(postorder)-1]
		i := m[val]

		// create root element
		root := &TreeNode{Val: val}
		root.Right = helper(i+1, in_right)
		root.Left = helper(in_left, i-1)

		return root

	}
	return helper(0, l-1)
}

//#1
func buildTree1(inorder []int, postorder []int) *TreeNode {
	// time: O(N)
	// space: O(D) where D means the depth of the tree
	in, post = len(inorder)-1, len(postorder)-1
	return build(math.MinInt32, inorder, postorder)
}

var in, post int

func build(stop int, inorder, postorder []int) *TreeNode {
	if post < 0 {
		return nil
	}
	if inorder[in] == stop {
		in--
		return nil
	}
	node := &TreeNode{postorder[post], nil, nil}
	post--
	node.Right = build(node.Val, inorder, postorder)
	node.Left = build(stop, inorder, postorder)
	return node
}

//#0
//go test .
//ok      example.com/Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal (cached) [no tests to run]
func buildTree0(inorder []int, postorder []int) *TreeNode {
	if inorder == nil && postorder == nil {
		return nil
	}

	if len(inorder) == 1 && len(postorder) == 1 {
		if inorder[0] != postorder[0] {
			return nil
		}

		return &TreeNode{Val: inorder[0]}
	}

	return nil
}

//Copied
//202 / 202 test cases passed.
// Status: Accepted
// Runtime: 36 ms
// Memory Usage: 19.2 MB
//Your runtime beats 10.49 % of golang submissions.
//Your memory usage beats 9.09 % of golang submissions.
//
// ==>
//Runtime: 52 ms
//Memory Usage: 24 MB
