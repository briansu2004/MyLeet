"""
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1000/
Search in a Binary Search Tree

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:
The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    #01
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        trav = root
        while trav:
            if trav.val == val:
                return trav
            elif trav.val < val:
                trav = trav.right
            else:
                trav = trav.left


if __name__ == "__main__":
    root = [4,2,7,1,3]
    val = 2
    print("searchBST({0}, {1}): {2}".format(root, val, Solution.searchBST(Solution, root, val)))


#01
# 36 / 36 test cases passed.
# Status: Accepted
# Runtime: 76 ms
# Memory Usage: 16.1 MB

