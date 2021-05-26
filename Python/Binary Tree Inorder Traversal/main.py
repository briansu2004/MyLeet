"""
https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2774/
Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [2,1]

Example 5:
Input: root = [1,null,2]
Output: [1,2]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    #02 iteratively
    def inorderTraversal(self, root):
        res, stack = [], []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack:
                return res
            node = stack.pop()
            res.append(node.val)
            root = node.right

    #01 recursively
    def inorderTraversal1(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        self.helper(self, root, res)
        return res
    
    def helper(self, root, res):
        if root:
            self.helper(self, root.left, res)
            res.append(root.val)
            self.helper(self, root.right, res)
        
if __name__ == "__main__":
    t = TreeNode()
    print("inorderTraversal({0}): {1}".format(t, Solution.inorderTraversal(Solution, t)))



# 01
# 68 / 68 test cases passed.
# Status: Accepted
# Runtime: 16 ms
# Memory Usage: 13.5 MB

#02
# 68 / 68 test cases passed.
# Status: Accepted
# Runtime: 8 ms
# Memory Usage: 13.4 MB
