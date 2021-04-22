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

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLevelorder(t *testing.T) {
	var n *Node

	//assert.Equal(t, levelOrder(n), []int{})

	n = &Node{Val: 0}
	//[[0]]
	assert.Equal(t, levelOrder(n), [][]int{[]int{0}})

	//Input: root = [1,null,3,2,4,null,5,6]
	//Output: [[1],[3,2,4],[5,6]]
	n = &Node{Val: 1, Children: []*Node{&Node{Val: 3, Children: []*Node{&Node{Val: 5}, &Node{Val: 6}}}, &Node{Val: 2}, &Node{Val: 4}}}
	assert.Equal(t, levelOrder(n), [][]int{[]int{1}, []int{3, 2, 4}, []int{5, 6}})

	//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	//Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
	n2 := &Node{Val: 2}

	n14 := &Node{Val: 14}
	n11 := &Node{Val: 11, Children: []*Node{n14}}
	n7 := &Node{Val: 7, Children: []*Node{n11}}
	n6 := &Node{Val: 6}
	n3 := &Node{Val: 3, Children: []*Node{n6, n7}}

	n12 := &Node{Val: 12}
	n8 := &Node{Val: 8, Children: []*Node{n12}}
	n4 := &Node{Val: 4, Children: []*Node{n8}}

	n13 := &Node{Val: 13}
	n9 := &Node{Val: 9, Children: []*Node{n13}}
	n10 := &Node{Val: 10}
	n5 := &Node{Val: 5, Children: []*Node{n9, n10}}

	n = &Node{Val: 1, Children: []*Node{n2, n3, n4, n5}}
	assert.Equal(t, levelOrder(n), [][]int{[]int{1}, []int{2, 3, 4, 5}, []int{6, 7, 8, 9, 10}, []int{11, 12, 13}, []int{14}})
}
