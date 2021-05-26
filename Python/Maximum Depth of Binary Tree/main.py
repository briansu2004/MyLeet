"""
https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/
Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2
Example 3:
Input: root = []
Output: 0
Example 4:
Input: root = [0]
Output: 1

Constraints:
The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    #02
    def maxDepth(self, root):
        if root == None:
            return 0
        stack = []
        currNode = root
        sk = []
        
        maxdep = curdep = 1
        while root.left != None or root.right != None:
            if currNode.left != None:
                stack.append(currNode)
                currNode = currNode.left
                curdep += 1
                sk.append(1)
            elif currNode.right != None:
                stack.append(currNode)
                currNode = currNode.right
                curdep += 1
                sk.append(0)
            else:
                curdep -= 1
                if sk[-1]:
                    stack[-1].left = None
                elif not sk[-1]:
                    stack[-1].right = None
                else: return 1
                currNode = stack.pop()
                sk.pop()
            
            
            if curdep > maxdep:
                maxdep = curdep
                
        return maxdep
                

    #01
    def maxDepth1(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        return max(self.maxDepth(Solution, root.left), self.maxDepth(Solution, root.right)) + 1
        

if __name__ == "__main__":
    t = TreeNode(4, left=TreeNode(3, left=TreeNode(1, left=TreeNode(0), right=TreeNode(2))), right=TreeNode(7))
    print("maxDepth(t) is: {0}".format(Solution.maxDepth(Solution, t)))


# 01
# 39 / 39 test cases passed.
# Status: Accepted
# Runtime: 20 ms
# Memory Usage: 16 MB
# Your runtime beats 98.95 % of python submissions.

# 02
# 39 / 39 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 15.6 MB
