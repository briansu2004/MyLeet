"""
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
"""

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    #02
    def isBalanced(self, root: TreeNode) -> bool:
        stack, node, depths, last = [],root,{},None
        
        while stack or node:
            if node:
                stack.append(node)
                node = node.left

            else:
                node = stack[-1]

                if not node.right or last == node.right:
                    node = stack.pop()
                    left_v, right_v = depths.get(node.left, 0), depths.get(node.right, 0)

                    if abs(left_v - right_v) > 1:
                        return False
                    else:
                        depths[node] = 1 + max(left_v, right_v)
                        last = node
                        node = None

                else:
                    node = node.right
        
        return True

    #01
    def helper(self, root):
        if root == None:
            return 0, True
        hl, lb = self.helper(self, root.left)
        hr, rb = self.helper(self, root.right)
        if lb and rb and abs(hl-hr) <= 1:
            return max(hl, hr) + 1, True
        else:
            return -1, False

    def isBalanced1(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        h, is_b = self.helper(self, root)
        return is_b


if __name__ == "__main__":
    nums = [3, 9, 20, None, None, 15, 7]
    print("isBalanced({0}): {1}".format(
        nums, Solution.isBalanced(Solution, nums)))


# 01
# 228 / 228 test cases passed.
# Status: Accepted
# Runtime: 52 ms
# Memory Usage: 18.4 MB

# 02
# 228 / 228 test cases passed.
# Status: Accepted
# Runtime: 48 ms
# Memory Usage: 15 MB
