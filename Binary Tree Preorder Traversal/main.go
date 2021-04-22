/*
https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [1,2]

Example 5:
Input: root = [1,null,2]
Output: [1,2]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

package main

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	n := []int{root.Val}

	if root.Left == nil && root.Right == nil {
		return n
	}

	if root.Left != nil {
		n = append(n, preorderTraversal(root.Left)...)
	}

	if root.Right != nil {
		n = append(n, preorderTraversal(root.Right)...)
	}

	return n
}

//69 / 69 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.1 MB
//Sorry. We do not have enough accepted submissions to show distribution chart.
//
