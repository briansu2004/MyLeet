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

func TestIsSymmetric(t *testing.T) {
	var n *TreeNode

	//Input: root = []
	//Output: false
	//assert.Equal(t, isSymmetric(n), false)

	//Input: root = [0]
	//Output: true
	n = &TreeNode{Val: 0}
	assert.Equal(t, isSymmetric(n), true)

	//Input: root = [1,null,2]
	//Output: true
	n = &TreeNode{Val: 1, Right: &TreeNode{Val: 2}}
	assert.Equal(t, isSymmetric(n), false)

	//Input: root = [1,2]
	//Output: false
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}}
	assert.Equal(t, isSymmetric(n), false)

	//Input: root = [1,2,2,3,4,4,3]
	//Output: true
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Left: &TreeNode{Val: 3}, Right: &TreeNode{Val: 4}}, Right: &TreeNode{Val: 2, Left: &TreeNode{Val: 4}, Right: &TreeNode{Val: 3}}}
	assert.Equal(t, isSymmetric(n), true)

	//Input: root = [1,2,3,null,4,5,6,null,null,7,null,null,null,8,9]
	//Output: false
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 7}}}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 6, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 9}}}}
	assert.Equal(t, isSymmetric(n), false)
}
