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
	"testing"

	"github.com/stretchr/testify/assert"
)

//ser := Constructor()
// deser := Constructor()
// data := ser.serialize(root)
// ans := deser.deserialize(data)

func TestSerialize(t *testing.T) {
	var root *TreeNode
	var s string

	ser := Constructor()

	//assert.Equal(t, lowestCommonAncestor(root, p, q), n)

	// Input: root = [1,2,3,null,null,4,5]
	// Output: [1,2,3,null,null,4,5]
	// Output Go: [1,2,3,nil,nil,4,5,nil,nil,nil,nil

	root = &TreeNode{Val: 1, Left: &TreeNode{Val: 2}, Right: &TreeNode{Val: 3, Left: &TreeNode{Val: 4}, Right: &TreeNode{Val: 5}}}

	//s = "1,2,3,nil,nil,4,5,nil,nil,nil,nil" //"1,2,3,null,null,4,5"
	s = "1,2,null,null,3,4,null,null,5,null,null"

	assert.Equal(t, ser.serialize(root), s)

}
