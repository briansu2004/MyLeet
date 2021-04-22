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

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestBuildTree(t *testing.T) {
	var n1, n2 []int
	var n *TreeNode

	//assert.Equal(t, buildTree(n1, n2), nil)

	// Input: inorder = [2], postorder = [2]
	// Output: [2]
	n1 = []int{2}
	n2 = []int{2}
	n = &TreeNode{Val: 2}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [1, 2], postorder = [1, 2]
	// Output: [1, 2]
	n1 = []int{1, 2}
	n2 = []int{1, 2}
	n = &TreeNode{Val: 2, Left: &TreeNode{Val: 1}}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [5, 6], postorder = [6, 5]
	// Output: [5, 6]
	n1 = []int{5, 6}
	n2 = []int{6, 5}
	n = &TreeNode{Val: 5, Right: &TreeNode{Val: 6}}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [13, 15, 18], postorder = [13, 18, 15]
	// Output: [5, 6]
	n1 = []int{13, 15, 18}
	n2 = []int{13, 18, 15}
	n = &TreeNode{Val: 15, Left: &TreeNode{Val: 13}, Right: &TreeNode{Val: 18}}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
	// Output: [3,9,20,null,null,15,7]
	n1 = []int{9, 3, 15, 20, 7}
	n2 = []int{9, 15, 7, 20, 3}
	n = &TreeNode{Val: 3, Left: &TreeNode{Val: 9}, Right: &TreeNode{Val: 20, Left: &TreeNode{Val: 15}, Right: &TreeNode{Val: 7}}}
	assert.Equal(t, buildTree(n1, n2), n)
}
