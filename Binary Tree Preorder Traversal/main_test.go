/*
https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
Given the root of a binary tree, return the preorderTraversal traversal of its TreeNodes' values.

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
The number of TreeNodes in the tree is in the range [0, 100].
-100 <= TreeNode.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestPreorderTraversal(t *testing.T) {
	var n *TreeNode

	//Input: root = []
	//Output: []
	assert.Equal(t, preorderTraversal(n), []int{})

	//Input: root = [1]
	//Output: [1]
	n = &TreeNode{Val: 1}
	assert.Equal(t, preorderTraversal(n), []int{1})

	//Input: root = [1,null,2,3]
	//Output: [1,2,3]
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2, Right: &TreeNode{Val: 3}}}
	assert.Equal(t, preorderTraversal(n), []int{1, 2, 3})

	//Input: root = [1,2]
	//Output: [1,2]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}}
	assert.Equal(t, preorderTraversal(n), []int{1, 2})

	//Input: root = [1,null,2]
	//Output: [1,2]
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	assert.Equal(t, preorderTraversal(n), []int{1, 2})

	//Input: root = [1,2,4,7,3,5,6,8,9]
	//Output: [1,2,4,7,3,5,6,8,9]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 7}}}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 6, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 9}}}}
	assert.Equal(t, preorderTraversal(n), []int{1, 2, 4, 7, 3, 5, 6, 8, 9})
}
