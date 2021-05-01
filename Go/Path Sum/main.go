/*
https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
Path Sum

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false

Example 3:
Input: root = [1,2], targetSum = 0
Output: false

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

package main

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//#1
func hasPathSum(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}

	if root.Left == nil && root.Right == nil && root.Val == targetSum {
		return true
	}

	return hasPathSum(root.Right, targetSum-root.Val) || hasPathSum(root.Left, targetSum-root.Val)
}

//#0
func hasPathSum0(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}

	if root.Left == nil && root.Right == nil {
		return root.Val == targetSum
	}

	if root.Left != nil && hasPathSum(root.Left, targetSum-root.Val) {
		return true
	}

	if root.Right != nil && hasPathSum(root.Right, targetSum-root.Val) {
		return true
	}

	return false
}

// 116 / 116 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 4.8 MB
//Your runtime beats 92.98 % of golang submissions.
//Your memory usage beats 14.38 % of golang submissions.
