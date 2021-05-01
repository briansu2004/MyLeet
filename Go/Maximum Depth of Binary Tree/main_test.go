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

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestmaxDepth(t *testing.T) {
	var n *TreeNode

	//Input: root = []
	//Output: 0
	assert.Equal(t, maxDepth(n), 0)

	//Input: root = [0]
	//Output: 1
	n = &TreeNode{Val: 0}
	assert.Equal(t, maxDepth(n), 1)

	//Input: root = [1,null,2]
	//Output: 2
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	assert.Equal(t, maxDepth(n), 2)

	//Input: root = [1,2]
	//Output: 2
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}}
	assert.Equal(t, maxDepth(n), 2)

	//Input: root = [3,9,20,null,null,15,7]
	//Output: 3
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	assert.Equal(t, maxDepth(n), 3)

	//Input: root = [1,2,3,null,4,5,6,null,null,7,null,null,null,8,9]
	//Output: 4
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 7}}}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 6, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 9}}}}
	assert.Equal(t, maxDepth(n), 4)
}
