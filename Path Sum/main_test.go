/*
https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestHasPathSum(t *testing.T) {
	var n *TreeNode
	var targetSum int

	//Input: root = [], targetSum = 1
	//Output: false
	targetSum = 0
	assert.Equal(t, hasPathSum(n, targetSum), false)

	//Input: root = [], targetSum = 1
	//Output: false
	targetSum = 1
	assert.Equal(t, hasPathSum(n, targetSum), false)

	//Input: root = [0], targetSum = 0
	//Output: true
	n = &TreeNode{Val: 0}
	targetSum = 0
	assert.Equal(t, hasPathSum(n, targetSum), true)

	//Input: root = [1], targetSum = 1
	//Output: true
	n = &TreeNode{Val: 1}
	targetSum = 1
	assert.Equal(t, hasPathSum(n, targetSum), true)

	//Input: root = [1,2], targetSum = 0
	//Output: false
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}}
	targetSum = 0
	assert.Equal(t, hasPathSum(n, targetSum), false)

	//Input: root = [1,null,2], targetSum = 3
	//Output: true
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	targetSum = 3
	assert.Equal(t, hasPathSum(n, targetSum), true)

	//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
	//Output: true
	n = &TreeNode{Val: 5, Left: &TreeNode{Val: 4, Left: &TreeNode{Val: 11, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 2}}}, Right: &TreeNode{Val: 8, Left: &TreeNode{Val: 13}, Right: &TreeNode{Val: 4, Right: &TreeNode{Val: 1}}}}
	targetSum = 22
	assert.Equal(t, hasPathSum(n, targetSum), true)
}
