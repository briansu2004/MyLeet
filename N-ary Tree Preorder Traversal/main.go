/*
https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/925/
N-ary Tree Preorder Traversal

Solution
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]

Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

package main

// Definition for a Node.
type Node struct {
	Val      int
	Children []*Node
}

func preorder(root *Node) []int {
	if root == nil {
		return []int{}
	}

	var nodeCount int
	count(root, &nodeCount)
	vals := make([]int, nodeCount)

	traverse(root, 0, &vals)

	return vals
}

func traverse(n *Node, iVals int, vals *[]int) int {
	(*vals)[iVals] = n.Val
	iVals++
	for i := 0; i < len(n.Children); i++ {
		iVals = traverse(n.Children[i], iVals, vals)
	}

	return iVals
}

func count(n *Node, nodes *int) {
	(*nodes)++
	for i := 0; i < len(n.Children); i++ {
		count(n.Children[i], nodes)
	}
}

//#1
func preorder1(root *Node) []int {
	if root == nil {
		return nil
	}

	var ret []int
	dfs(root, &ret)
	return ret
}

func dfs(node *Node, ret *[]int) {
	if node == nil {
		return
	}

	*ret = append(*ret, node.Val)
	for _, child := range node.Children {
		dfs(child, ret)
	}
}

//#0
//Preorder Traversal: Visit the root node, then traverse the left subtree and finally traverse the right subtree.
func preorder0(root *Node) []int {
	if root == nil {
		return []int{}
	}

	if root.Children == nil {
		return []int{root.Val}
	}

	n := []int{root.Val}
	for _, v := range root.Children {
		n = append(n, preorder(v)...)
	}

	return n
}

//38 / 38 test cases passed.
// Status: Accepted
// Runtime: 4 ms
// Memory Usage: 5.8 MB
//Your memory usage beats 6.86 % of golang submissions.
//
// =>
//Runtime: 8 ms
//Memory Usage: 4.2 MB
//
// =>
//Runtime: 0 ms
//Memory Usage: 3.8 MB
//Your runtime beats 100.00 % of golang submissions.
