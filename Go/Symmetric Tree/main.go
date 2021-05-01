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

// Definition for a Node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//#3
func isSymmetric(root *TreeNode) bool {
	return isMirror(root, root)
}

func isMirror(l *TreeNode, r *TreeNode) bool {
	if l == nil && r == nil {
		return true
	}

	if l == nil || r == nil {
		return false
	}

	return l.Val == r.Val && isMirror(l.Left, r.Right) && isMirror(l.Right, r.Left)
}

//#2
func isSymmetric2(root *TreeNode) bool {
	return helper(root, root)
}

func helper2(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}
	if left == nil || right == nil {
		return false
	}
	return left.Val == right.Val && helper(left.Right, right.Left) && helper(left.Left, right.Right)
}

//#1
func isSymmetric1(root *TreeNode) bool {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return true
	}
	if (root.Left != nil && root.Right == nil) || (root.Right != nil && root.Left == nil) {
		return false
	}
	if root.Left.Val != root.Right.Val {
		return false
	}
	return helper(root.Left, root.Right)
}

func helper(t1 *TreeNode, t2 *TreeNode) bool {
	if (t1.Left != nil && t2.Right == nil) || (t1.Left == nil && t2.Right != nil) {
		return false
	}
	if (t1.Right != nil && t2.Left == nil) || (t1.Right == nil && t2.Left != nil) {
		return false
	}
	if t1.Left != nil && t2.Right != nil {
		if t1.Left.Val != t2.Right.Val {
			return false
		}
		if !helper(t1.Left, t2.Right) {
			return false
		}
	}
	if t1.Right != nil && t2.Left != nil {
		if t1.Right.Val != t2.Left.Val {
			return false
		}
		if !helper(t1.Right, t2.Left) {
			return false
		}
	}
	return true
}

//not working!
//#0
func isSymmetric0(root *TreeNode) bool {
	if root == nil {
		return false
	}

	if root.Left == nil || root.Right == nil {
		return true
	}

	if root.Left != nil && root.Right == nil {
		return false
	}

	if root.Left == nil && root.Right != nil {
		return false
	}

	if root.Left.Val != root.Right.Val {
		return false
	}

	if isSymmetric(root.Left) && isSymmetric(root.Right) {
		return false
	}
	return false
}

//#2
// 194 / 194 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 2.9 MB
//
//#3
