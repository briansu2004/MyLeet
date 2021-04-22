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

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//Inorder Traversal: Traverse the left subtree, then visit the root node and finally traverse the right subtree.

//#3
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	currLevelCount := 1
	queue := make([]*TreeNode, 0)
	res := make([][]int, 0)

	queue = append(queue, root)

	for len(queue) > 0 {

		var nLevelCount int
		nodesVals := make([]int, 0)

		for i := 0; i < currLevelCount; i++ {
			n := queue[0]

			if n != nil {
				nodesVals = append(nodesVals, n.Val)
				if n.Left != nil {
					queue = append(queue, n.Left)
					nLevelCount++
				}
				if n.Right != nil {
					queue = append(queue, n.Right)
					nLevelCount++
				}
			}

			queue = queue[1:]
		}
		res = append(res, nodesVals)
		currLevelCount = nLevelCount
	}

	return res
}

//#2
func levelOrder2(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	return travel([]*TreeNode{root}, [][]int{})
}

func travel(children []*TreeNode, traversal [][]int) [][]int {
	l := len(children)
	if l == 0 {
		return traversal
	}
	c := []int{}
	for _, val := range children {
		if val.Left != nil {
			children = append(children, val.Left)
		}
		if val.Right != nil {
			children = append(children, val.Right)
		}
		c = append(c, val.Val)
	}
	traversal = append(traversal, c)
	return travel(children[l:], traversal)
}

//#1
func levelOrder1(root *TreeNode) [][]int {
	result := [][]int{}
	queue := []*TreeNode{root}
	for len(queue) != 0 {
		level := []int{}
		l := len(queue)
		for i := 0; i < l; i++ {
			if queue[0] != nil {
				level = append(level, queue[0].Val)
				queue = append(queue, queue[0].Left)
				queue = append(queue, queue[0].Right)
			}
			queue = queue[1:]
		}
		result = append(result, level)
	}
	return result[:len(result)-1]
}

//not working
func levelOrder0(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	n := [][]int{[]int{root.Val}}

	if root.Left == nil && root.Right == nil {
		return n
	} else if root.Left != nil && root.Right == nil {
		n = append(n, []int{root.Left.Val})
	} else if root.Left == nil && root.Right != nil {
		n = append(n, []int{root.Right.Val})
	} else {
		n = append(n, []int{root.Left.Val, root.Right.Val})
	}

	return n
}

//Copied
//34 / 34 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 2.8 MB
//Your memory usage beats 39.11 % of golang submissions
//
// ==>
//Runtime: 0 ms
//Memory Usage: 3.2 MB
//
// ==>
//Runtime: 0 ms
//Memory Usage: 2.8 MB
//Your memory usage beats 98.94 % of golang submissions
