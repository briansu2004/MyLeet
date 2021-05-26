"""
https://leetcode.com/problems/cousins-in-binary-tree/
993. Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Constraints:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
"""

from typing import Deque


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    #02
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        def dfs(node, parent, depth, mod):
            if node:
                if node.val == mod:
                    return depth, parent
                return dfs(node.left, node, depth + 1, mod) or dfs(node.right, node, depth + 1, mod)
        dx, px, dy, py = dfs(root, None, 0, x) + dfs(root, None, 0, y)
        return dx == dy and px != py

    #01
    def isCousins1(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue = Deque([root])
        
        while queue:
            size = len(queue)
            temp = {}
            for i in range(size):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                    temp[node.left.val] = node.val
                if node.right:
                    queue.append(node.right)
                    temp[node.right.val] = node.val
            
            if x in temp and y in temp and temp[x] != temp[y]:
                return True
        
        return False

if __name__ == "__main__":
    t = TreeNode(1, left=TreeNode(2, right=TreeNode(4)), right=TreeNode(3))
    x = 1
    y = 2
    print("isCousins({0}, {1}, {2}): {3}".format(t, x, y, Solution.isCousins(Solution, t, x, y)))



# # 01
# Runtime: 20 ms, faster than 66.49% of Python online submissions for Cousins in Binary Tree.
# Memory Usage: 13.4 MB, less than 62.70% of Python online submissions for Cousins in Binary Tree.

#02
# Runtime: 24 ms, faster than 35.95% of Python online submissions for Cousins in Binary Tree.
# Memory Usage: 13.5 MB, less than 62.70% of Python online submissions for Cousins in Binary Tree.
