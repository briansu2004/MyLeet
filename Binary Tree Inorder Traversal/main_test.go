/*
https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

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
Output: [1,2]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up:
Recursive solution is trivial, could you do it iteratively?
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestInorderTraversal(t *testing.T) {
	var n *TreeNode

	//Input: root = []
	//Output: []
	assert.Equal(t, inorderTraversal(n), []int{})

	//Input: root = [1]
	//Output: [1]
	n = &TreeNode{Val: 1}
	assert.Equal(t, inorderTraversal(n), []int{1})

	//Input: root = [1,null,2,3]
	//Output: [1,3,2]
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2, Left: &TreeNode{Val: 3}}}
	assert.Equal(t, inorderTraversal(n), []int{1, 3, 2})

	//Input: root = [1,2]
	//Output: [2,1]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}}
	assert.Equal(t, inorderTraversal(n), []int{2, 1})

	//Input: root = [1,null,2]
	//Output: [1,2]
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	assert.Equal(t, inorderTraversal(n), []int{1, 2})

	//Input: root = [1,2,null,4,7,null,3,5,null,null,6,8,9] ???
	//Output: [2, 7, 4, 1, 5, 3, 8, 6, 9] //[4,3,6,2,8,5,9,7,1]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 7}}}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 6, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 9}}}}
	assert.Equal(t, inorderTraversal(n), []int{2, 7, 4, 1, 5, 3, 8, 6, 9})

	//Input: root = [1,2,null,4,7,null,3,5,null,null,6,8,9]
	//Output: [4,3,6,2,8,5,9,7,1]
}
