/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
Serialize and Deserialize Binary Tree

Solution
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [1,2]

Constraints:
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
*/

/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor();
 * deser := Constructor();
 * data := ser.serialize(root);
 * ans := deser.deserialize(data);
 */

package main

import (
	"strconv"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//#2
type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	s := ""

	if root == nil {
		return s
	}

	s = s + strconv.Itoa(root.Val)

	if root.Left != nil {
		s = s + "," + this.serialize(root.Left)
	} else {
		s = s + "," + "null"
	}

	if root.Right != nil {
		s = s + "," + this.serialize(root.Right)
	} else {
		s = s + "," + "null"
	}

	return s
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	ints := strings.Split(data, ",")

	return dHelper(&ints)
}

func dHelper(data *[]string) *TreeNode {
	if len(*data) == 0 {
		return nil
	}

	//if (*data)[0] == "null" {
	//  (*data) = (*data)[1:]
	// return nil
	//}
	v, err := strconv.Atoi((*data)[0])
	if err != nil {
		*data = (*data)[1:]
		return nil
	}

	*data = (*data)[1:]
	root := &TreeNode{Val: v}
	root.Left = dHelper(data)
	root.Right = dHelper(data)

	return root
}

//#1
type Codec1 struct {
}

func Constructor1() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize1(root *TreeNode) string {

	if root == nil {
		return ""
	}

	queue := []*TreeNode{root}
	c := []string{strconv.Itoa(root.Val)}

	for len(queue) > 0 {
		l := len(queue)
		for i := 0; i < l; i++ {
			if queue[i].Left != nil {
				queue = append(queue, queue[i].Left)
			}
			if queue[i].Right != nil {
				queue = append(queue, queue[i].Right)
			}
			add(&c, queue[i].Left)
			add(&c, queue[i].Right)
		}
		queue = queue[l:]
	}

	res := strings.Join(c, ",")
	return res
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize1(data string) *TreeNode {
	c := strings.Split(data, ",")

	if len(data) == 0 {
		return nil
	}

	t := &TreeNode{Val: myAtoi(c[0])}
	queue := []*TreeNode{t}

	i := 1
	for len(queue) > 0 {
		l := len(queue)
		for j := 0; j < l; j++ {
			if c[i] == "nil" {
				queue[j].Left = nil
			} else {
				queue[j].Left = &TreeNode{Val: myAtoi(c[i])}
				queue = append(queue, queue[j].Left)
			}
			i++
			if c[i] == "nil" {
				queue[j].Right = nil
			} else {
				queue[j].Right = &TreeNode{Val: myAtoi(c[i])}
				queue = append(queue, queue[j].Right)
			}
			i++
		}
		queue = queue[l:]
	}
	return t
}

func add(c *[]string, node *TreeNode) {
	if node == nil {
		*c = append(*c, "nil")
	} else {
		*c = append(*c, strconv.Itoa(node.Val))
	}
}

func myAtoi(s string) int {
	a, err := strconv.Atoi(s)
	if err != nil {
		panic(a)
	}
	return a
}

// 52 / 52 test cases passed.
// Status: Accepted
// Runtime: 548 ms
// Memory Usage: 90.8 MB
//
// ==>
//
