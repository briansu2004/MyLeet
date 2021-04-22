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

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//* Preorder Traversal: Visit the root node, then traverse the left subtree and finally traverse the right subtree.
//* Inorder Traversal: Traverse the left subtree, then visit the root node and finally traverse the right subtree.

//#3
func buildTree(preorder []int, inorder []int) *TreeNode {
	inPos := make(map[int]int, len(inorder))

	for i := range inorder {
		inPos[inorder[i]] = i
	}
	return help(preorder, 0, len(preorder)-1, 0, inPos)
}

func help(pre []int, preStart, preEnd, inStart int, inPos map[int]int) *TreeNode {
	if preStart > preEnd {
		return nil
	}
	root := &TreeNode{Val: pre[preStart]}
	rootIndex := inPos[pre[preStart]]
	preLength := rootIndex - inStart
	root.Left = help(pre, preStart+1, preStart+preLength, inStart, inPos)
	root.Right = help(pre, preStart+preLength+1, preEnd, rootIndex+1, inPos)

	return root
}

//#2
func buildTree2(preorder []int, inorder []int) *TreeNode {
	if len(inorder) != len(preorder) || len(preorder) == 0 || len(preorder) == 0 {
		return nil
	}
	rootVal := preorder[0]
	root := &TreeNode{
		Val: rootVal,
	}
	i := 0
	for i = 0; i < len(inorder); i++ {
		if inorder[i] == rootVal {
			break
		}
	}
	root.Left = buildTree(preorder[1:i+1], inorder[:i])
	root.Right = buildTree(preorder[i+1:], inorder[i+1:])
	return root
}

//#1
func buildTree1(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	root := &TreeNode{
		Val: preorder[0],
	}
	if len(preorder) == 1 {
		return root
	}

	var index int
	for i, v := range inorder {
		if v == root.Val {
			index = i
			break
		}
	}

	root.Left = buildTree(preorder[1:index+1], inorder[0:index])
	root.Right = buildTree(preorder[index+1:], inorder[index+1:])
	return root
}

//#0
func buildTree0(preorder []int, inorder []int) *TreeNode {
	if inorder == nil && preorder == nil {
		return nil
	}

	if len(inorder) == 1 && len(preorder) == 1 {
		if inorder[0] != preorder[0] {
			return nil
		}

		return &TreeNode{Val: inorder[0]}
	}

	return nil
}

//Copied
//202 / 202 test cases passed.
// Status: Accepted
// Runtime: 16 ms
// Memory Usage: 9.7 MB
//Your runtime beats 93.82 % of golang submissions.
//Your memory usage beats 95.37 % of golang submissions.
