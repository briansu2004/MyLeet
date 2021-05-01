/*
https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
Binary Tree Level Order Traversal

Solution
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLevelOrder(t *testing.T) {
	var n *TreeNode

	//Input: root = []
	//Output: []
	//assert.Equal(t, levelOrder(n), [][]int{})

	//Input: root = [1]
	//Output: [[1]]
	n = &TreeNode{Val: 1}
	assert.Equal(t, levelOrder(n), [][]int{[]int{1}})

	//Input: root = [3,9,20,null,null,15,7]
	//Output: [[3],[9,20],[15,7]]
	n = &TreeNode{Val: 3, Left: &TreeNode{Val: 9}, Right: &TreeNode{Val: 20, Left: &TreeNode{Val: 15}, Right: &TreeNode{Val: 7}}}
	assert.Equal(t, levelOrder(n), [][]int{[]int{3}, []int{9, 20}, []int{15, 7}})

	//Input: root = [1,2,3,null,4,5,6,null,null,7,null,null,null,8,9]
	//Output: [[1],[2,3],[4,5,6],[7],[8,9]]
	n = &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 7}}}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 5}, Right: &TreeNode{Val: 6, Left: &TreeNode{Val: 8}, Right: &TreeNode{Val: 9}}}}
	//assert.Equal(t, levelOrder(n), [][]int{[]int{1}, []int{2, 3}, []int{4, 5, 6}, []int{7}, []int{8, 9}})
	assert.Equal(t, levelOrder(n), [][]int{[]int{1}, []int{2, 3}, []int{4, 5, 6}, []int{7, 8, 9}})
}
