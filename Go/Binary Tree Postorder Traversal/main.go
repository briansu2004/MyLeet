/*
https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
Binary Tree Postorder Traversal

Solution
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [2,1]

Example 5:
Input: root = [1,null,2]
Output: [2,1]

Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up:
Recursive solution is trivial, could you do it iteratively?
*/

package main

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//Postorder Traversal: Traverse the left subtree, then traverse the right subtree and finally visit the root node.

//#1
func postorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	var dfs func(root *TreeNode)
	dfs = func(root *TreeNode) {
		if root != nil {
			dfs(root.Left)
			dfs(root.Right)
			result = append(result, root.Val)
		}
	}
	dfs(root)
	return result
}

//#0
func postorderTraversal0(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	if root.Left == nil && root.Right == nil {
		return []int{root.Val}
	}

	var n []int
	n = append(postorderTraversal(root.Left), postorderTraversal(root.Right)...)
	n = append(n, []int{root.Val}...)

	return n
}

//68 / 68 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.1 MB
//Sorry. We do not have enough accepted submissions to show distribution chart.
//
// ==>
//Runtime: 0 ms
//Memory Usage: 2 MB
