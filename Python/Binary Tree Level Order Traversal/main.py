"""
https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2784/
Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
"""

from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    #02
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return None
        
        if root.left is None and root.right is None:
            return [[root.val]]
        
        level_order = []
        level_limit = 0
        
        tmp_stack = [root]
        tmp_level = []
        
        cur_node = root
        
        while tmp_stack:
            #print(tmp_stack)
            level_limit = len(tmp_stack)
            
            while level_limit != 0:
                #print(level_limit)
                cur_node = tmp_stack.pop(0)
                level_limit -= 1
                tmp_level += cur_node.val,
                
                if cur_node.left is not None:
                    tmp_stack.append(cur_node.left)
                
                if cur_node.right is not None:
                    tmp_stack.append(cur_node.right)
                
                
            level_order += tmp_level,
            tmp_level = []
        
        return level_order

    #01 
    def levelOrder1(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root: return []
        queue, res = deque([root]), []
        
        while queue:
            cur_level, size = [], len(queue)
            for i in range(size):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                cur_level.append(node.val)
            res.append(cur_level)

        return res

if __name__ == "__main__":
    t = TreeNode()
    print("levelOrder({0}): {1}".format(t, Solution.levelOrder(Solution, t)))



# 01
# 34 / 34 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 13.8 MB

# 02
# 34 / 34 test cases passed.
# Status: Accepted
# Runtime: 28 ms
# Memory Usage: 13.6 MB
