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

func TestPostorderTraversal(t *testing.T) {
	var n *TreeNode

	//Input: root = []
	//Output: []
	assert.Equal(t, postorderTraversal(n), []int{})

	//Input: root = [1]
	//Output: [1]
	n = &TreeNode{Val: 1}
	assert.Equal(t, postorderTraversal(n), []int{1})

	//Input: root = [1,2]
	//Output: [2,1]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}}
	assert.Equal(t, postorderTraversal(n), []int{2, 1})

	//Input: root = [1,null,2]
	//Output: [2,1]
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	assert.Equal(t, postorderTraversal(n), []int{2, 1})

	//Input: root = [1,null,2,3]
	//Output: [3,2,1]
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2, Right: &TreeNode{Val: 3}}}
	assert.Equal(t, postorderTraversal(n), []int{3, 2, 1})

	//Input: root = [1,2,null,4,7,null,3,5,null,null,6,8,9]
	//Output: [7,4,2,5,8,9,6,3,1]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 7}}}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 6, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 9}}}}
	assert.Equal(t, postorderTraversal(n), []int{7, 4, 2, 5, 8, 9, 6, 3, 1})

	//Input: root = [1,2,null,4,7,null,3,5,null,null,6,8,9]
	//Output: [6,3,4,8,9,5,7,2,1]
}
