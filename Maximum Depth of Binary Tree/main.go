/*
https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
Maximum Depth of Binary Tree

Solution
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Example 3:
Input: root = []
Output: 0

Example 4:
Input: root = [0]
Output: 1

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
*/

package main

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//#1
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l, r := maxDepth(root.Left), maxDepth(root.Right)
	return max(l, r) + 1
}

//#0
func maxDepth0(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

//39 / 39 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 4.4 MB
//Your memory usage beats 18.53 % of golang submissions.
//
// ==>
//Runtime: 0 ms
//Memory Usage: 4.4 MB
