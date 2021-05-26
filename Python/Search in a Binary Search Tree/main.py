"""
https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
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

    def show(self):
        print(self.val)
        if self.left != None:
            self.left.show()
        if self.right != None:
            self.right.show()


class Solution:
    # 02
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return None
        if root.val == val:
            return root
        if root.val > val:
            root.right = None
            return self.searchBST(self, root.left, val)
        else:
            root.left = None
            return self.searchBST(self, root.right, val)

    # 01
    def searchBST1(self, root: TreeNode, val: int) -> TreeNode:
        if root == None or root.val == val:
            return root
        if root.val > val:
            return self.searchBST(self, root.left, val)
        else:
            return self.searchBST(self, root.right, val)


if __name__ == "__main__":
    t = TreeNode(4, left=TreeNode(2, left=TreeNode(
        1), right=TreeNode(3)), right=TreeNode(7))
    t.show()

    print()

    o = Solution.searchBST(self=Solution, root=t, val=2)
    o.show()


# 01
# 36 / 36 test cases passed.
# Status: Accepted
# Runtime: 108 ms
# Memory Usage: 16.2 MB
