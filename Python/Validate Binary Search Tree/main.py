"""
https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
Validate Binary Search Tree

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
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    #02
    def isValidBST(self, root, lo=float('-inf'), hi=float('inf')):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True

        if not lo < root.val < hi:
            return False
        
        return self.isValidBST(root.left, lo, min(root.val, hi)) and \
               self.isValidBST(root.right, max(lo, root.val), hi)

    #01
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        is_valid = True
        
        def walk(node: TreeNode):
            nonlocal is_valid
        
            this_min = node.val
            this_max = node.val
            if node.left:    
                # Ensure left subtree is valid.
                lmin, lmax = walk(node.left)
                # The left subtree contains only nodes with keys less than the node's key.
                if lmax >= node.val:
                    is_valid = False
                this_min = min(this_min, lmin)
                this_max = max(this_max, lmax)
            if node.right:
                # Ensure right subtree is valid.
                rmin, rmax = walk(node.right)
                # The right subtreecontains only nodes with keys greater than the node's key.
                if rmin <= node.val:
                    is_valid = False
                this_min = min(this_min, rmin)
                this_max = max(this_max, rmax)
            
            return this_min, this_max
        
        if root:
            walk(root)
        return is_valid

if __name__ == "__main__":
    t = TreeNode(4)
    print("{0} is: {1}".format(t, Solution.isValidBST(Solution, t)))

    t = TreeNode(5, TreeNode(2), TreeNode(8))
    print("{0} is: {1}".format(t, Solution.isValidBST(Solution, t)))

    t = TreeNode(2, TreeNode(9), TreeNode(7))
    print("{0} is: {1}".format(t, Solution.isValidBST(Solution, t)))

    t = TreeNode(5, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(8, TreeNode(7), TreeNode(13)))
    print("{0} is: {1}".format(t, Solution.isValidBST(Solution, t)))

# 01

# # 02
# 77 / 77 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 17.9 MB

# 79 / 79 test cases passed.
# Status: Accepted
# Runtime: 44 ms
# Memory Usage: 16.5 MB