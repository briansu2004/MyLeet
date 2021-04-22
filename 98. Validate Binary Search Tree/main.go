/*
https://leetcode.com/problems/merge-intervals/
98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
The number of nodes in the tree is in the range [1, 10 power of 4].
-2 power of 31 <= Node.val <= 2 power of 31 - 1
*/

package main

import "fmt"

// import "fmt"

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isValidBST(root *TreeNode) bool {
	return RecValidate(root, nil, nil)
}

func RecValidate(n, min, max *TreeNode) bool {
	if n == nil {
		return true
	}
	if min != nil && n.Val <= min.Val {
		return false
	}
	if max != nil && n.Val >= max.Val {
		return false
	}
	return RecValidate(n.Left, min, n) && RecValidate(n.Right, n, max)
}

// func getLeftValMin(t *TreeNode) int {
// 	// make sure t is not nil
// 	l := t.Left

// 	//if !isValidBST(l)

// 	if l == nil {
// 		return t.Val
// 	}
// 	return getLeftValMin(l)
// }

// func getRightValMax(t *TreeNode) int {
// 	// make sure t is not nil
// 	r := t.Right
// 	if r == nil {
// 		return t.Val
// 	}
// 	return getLeftValMin(r)
// }

// func isValidBST(root *TreeNode) bool {
// 	if root == nil {
// 		return false
// 	}

// 	//root != nil
// 	if root.Left == nil && root.Right == nil {
// 		return true
// 	}

// 	//if Left is not null
// 	//* Left needs to be ValidBST
// 	//and
// 	//* Left's right max needs to be smaller than Val
// 	if root.Left != nil && (!isValidBST(root.Left) || root.Val <= getRightValMax(root.Left)) {
// 		return false
// 	}

// 	//if Right is not null
// 	//* Right needs to be ValidBST
// 	//and
// 	//* Right's left min needs to be greater than Val
// 	if root.Right != nil && (!isValidBST(root.Right) || root.Val >= getLeftValMin(root.Right)) {
// 		return false
// 	}

// 	//Only return true with all these conditions
// 	if isValidBST(root.Left) && isValidBST(root.Right) && root.Val > getRightValMax(root.Left) && root.Val < getLeftValMin(root.Right) {
// 		//if isValidBST(root.Left) && isValidBST(root.Right) {
// 		return true
// 	}

// 	return false
// }

func main() {
	//fmt.Println("getLeftValMin(nil):", getLeftValMin(nil))
	//fmt.Println("getRightValMax(nil):", getRightValMax(nil))

	//t = nil
	//fmt.Println("[null] - Expected: false; Output:", isValidBST(nil))

	var t TreeNode
	t = TreeNode{Val: 3, Left: &TreeNode{Val: 1, Left: &TreeNode{Val: 0}, Right: &TreeNode{Val: 2, Right: &TreeNode{Val: 3}}}, Right: &TreeNode{Val: 5, Left: &TreeNode{Val: 4}, Right: &TreeNode{Val: 6}}}
	fmt.Println("[3,1,5,0,2,4,6,null,null,null,3] - Expected: false; Output:", isValidBST(&t))
	//[3,1,5,0,2,4,6,null,null,null,3]

	t = TreeNode{Val: 2, Left: &TreeNode{Val: 1}, Right: &TreeNode{Val: 3}}
	fmt.Println("[2,1,3] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 2, Left: &TreeNode{Val: 1}, Right: &TreeNode{Val: 3}}
	fmt.Println("[2,1,3] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 0}
	fmt.Println("[0] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 1}
	fmt.Println("[1] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: -3}
	fmt.Println("[-3] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 5, Left: &TreeNode{Val: 1}, Right: &TreeNode{Val: 4, Left: &TreeNode{Val: 3}, Right: &TreeNode{Val: 6}}}
	fmt.Println("[5,1,4,null,null,3,6] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 1, Left: &TreeNode{Val: 2}, Right: &TreeNode{Val: 3}}
	fmt.Println("[1,2,3] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 9, Left: &TreeNode{Val: 7}, Right: &TreeNode{Val: 8}}
	fmt.Println("[9,7,8] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 16, Left: &TreeNode{Val: 10, Left: &TreeNode{Val: 7}}, Right: &TreeNode{Val: 30, Left: &TreeNode{Val: 29}, Right: &TreeNode{Val: 40}}}
	fmt.Println("[16,10,30,7,null,29,40] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 0, Left: &TreeNode{Val: -1}}
	fmt.Println("[0,-1,null] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 0, Right: &TreeNode{Val: 1}}
	fmt.Println("[0,null,1] - Expected: true; Output:", isValidBST(&t))

	t = TreeNode{Val: 0, Right: &TreeNode{Val: -1}}
	fmt.Println("[0,null,-1] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 0, Left: &TreeNode{Val: 1}}
	fmt.Println("[0,1,null] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 32, Left: &TreeNode{Val: 26, Left: &TreeNode{Val: 19, Right: &TreeNode{Val: 27}}}, Right: &TreeNode{Val: 47, Right: &TreeNode{Val: 56}}}
	fmt.Println("[32,26,47,19,null,null,56,null,27] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 32, Left: &TreeNode{Val: 26, Left: &TreeNode{Val: 19, Left: &TreeNode{Val: 6}, Right: &TreeNode{Val: 27}}}, Right: &TreeNode{Val: 47, Right: &TreeNode{Val: 56}}}
	fmt.Println("[32,26,47,19,null,null,56,6,27] - Expected: false; Output:", isValidBST(&t))

	t = TreeNode{Val: 32, Left: &TreeNode{Val: 26, Left: &TreeNode{Val: 19, Left: &TreeNode{Val: 6}, Right: &TreeNode{Val: 27}}}, Right: &TreeNode{Val: 47, Right: &TreeNode{Val: 70, Left: &TreeNode{Val: 20}, Right: &TreeNode{Val: 80}}}}
	fmt.Println("[32,26,47,19,70,6,27,20,80] - Expected: false; Output:", isValidBST(&t))
}

//Wrong Answer
//Testcase
// [0]
// [1]
// [2,1,3]
// [5,1,4,null,null,3,6]
// [1,2,3]
// [9,7,8]
// [16,10,30,7,null,29,40]
// [0,-1,null]
// [0,null,1]
// [0,null,-1]
// [0,1,null]
// [32,26,47,19,null,null,56,null,27]
// [32,26,47,19,null,null,56,6,27]
// [32,26,47,19,70,6,27,20,80]
// [3,1,5,0,2,4,6,null,null,null,3]
//
// 77 / 77 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 5.4 MB
