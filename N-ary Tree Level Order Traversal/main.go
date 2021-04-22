/*
https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/915/
N-ary Tree Level Order Traversal

Solution
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

Constraints:
The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 104]
*/

package main

// Definition for a Node.
type Node struct {
	Val      int
	Children []*Node
}

//Level-order Traversal: Traverse the tree level by level.

//#3
func levelOrder(root *Node) [][]int {
	if root == nil {
		return nil
	}

	var (
		res [][]int
		que = newQueue()
	)

	que.push(root)

	for !que.isEmpty() {
		size := que.len()
		level := make([]int, size)

		for i := 0; i < size; i++ {
			node := que.pop()
			level[i] = node.Val
			que.push(node.Children...)
		}

		res = append(res, level)
	}

	return res
}

type queue struct {
	data []*Node
}

func newQueue() *queue {
	return &queue{
		data: make([]*Node, 0),
	}
}

func (x *queue) isEmpty() bool {
	return len(x.data) == 0
}

func (x *queue) pop() *Node {
	v := x.data[0]
	x.data = x.data[1:]
	return v
}

func (x *queue) push(v ...*Node) {
	x.data = append(x.data, v...)
}

func (x *queue) len() int {
	return len(x.data)
}

//#2
func levelOrder2(root *Node) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}
	q := []*Node{root}
	for len(q) > 0 {
		size := len(q)
		tmp := []int{}
		for i := 0; i < size; i++ {
			cur := q[0]
			q = q[1:]
			tmp = append(tmp, cur.Val)
			for _, v := range cur.Children {
				q = append(q, v)
			}
		}
		res = append(res, tmp)
	}
	return res
}

//#1
func levelOrder1(root *Node) [][]int {
	res := [][]int{}
	recursive(root, 0, &res)
	return res
}

func recursive(root *Node, level int, res *[][]int) {
	if root == nil {
		return
	}

	for _, v := range root.Children {
		recursive(v, level+1, res)
	}

	for len(*res) <= level {
		*res = append(*res, []int{})
	}

	(*res)[level] = append((*res)[level], root.Val)
}

//Copied
//37 / 37 test cases passed.
// Status: Accepted
// Runtime: 0 ms
// Memory Usage: 4.2 MB
//Your memory usage beats 91.18 % of golang submissions.
//
// ==>
//Runtime: 0 ms
//Memory Usage: 4.3 MB
//
// ==>
//Runtime: 0 ms
//Memory Usage: 4.1 MB
//Your memory usage beats 91.18 % of golang submissions.
