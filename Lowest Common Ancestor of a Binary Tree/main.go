/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
*/

package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//#3
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	if root == p || root == q {
		return root
	}

	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	if left != nil && right != nil {
		return root
	}
	if left == nil {
		return right
	}
	return left
}

//#2
func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	if poll(root.Left, p) && poll(root.Left, q) {
		return lowestCommonAncestor(root.Left, p, q)
	}
	if poll(root.Right, q) && poll(root.Right, p) {
		return lowestCommonAncestor(root.Right, p, q)
	}
	return root
}

func poll(root, p *TreeNode) bool {
	if root == p {
		return true
	}
	if root == nil {
		return false
	}
	return poll(root.Left, p) || poll(root.Right, p)
}

//#1
func lowestCommonAncestor1(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	if root == p || root == q {
		return root
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left != nil && right != nil {
		return root
	}
	if left == nil {
		return right
	}
	return left
}

//31 / 31 test cases passed.
// Status: Accepted
// Runtime: 12 ms
// Memory Usage: 7.1 MB
//
// ==>
//Runtime: 1044 ms
//Memory Usage: 6.2 MB
//
// ==>
//
