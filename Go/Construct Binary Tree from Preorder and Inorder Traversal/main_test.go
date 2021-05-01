/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/
Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
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

	// Input: inorder = [2], preorder = [2]
	// Output: [2]
	n1 = []int{2}
	n2 = []int{2}
	n = &TreeNode{Val: 2}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [1, 2], preorder = [2, 1]
	// Output: [1, 2]
	n1 = []int{2, 1}
	n2 = []int{1, 2}
	n = &TreeNode{Val: 2, Left: &TreeNode{Val: 1}}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [6, 5], preorder = [5, 6]
	// Output: [5, null, 6]
	n1 = []int{5, 6}
	n2 = []int{5, 6}
	n = &TreeNode{Val: 5, Right: &TreeNode{Val: 6}}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [15, 13, 18], preorder = [13, 15, 18]
	// Output: [15, 13, 18]
	n1 = []int{13, 15, 18}
	n2 = []int{15, 13, 18}
	n = &TreeNode{Val: 13, Left: &TreeNode{Val: 15}, Right: &TreeNode{Val: 18}}
	assert.Equal(t, buildTree(n1, n2), n)

	// Input: inorder = [3,9,20,15,7], preorder = [9,3,15,20,7]
	// Output: [3,9,20,null,null,15,7]
	n1 = []int{3, 9, 20, 15, 7}
	n2 = []int{9, 3, 15, 20, 7}
	n = &TreeNode{Val: 3, Left: &TreeNode{Val: 9}, Right: &TreeNode{Val: 20, Left: &TreeNode{Val: 15}, Right: &TreeNode{Val: 7}}}
	assert.Equal(t, buildTree(n1, n2), n)
}
