"""
https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/919/
Maximum Depth of N-ary Tree

Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5

Constraints:
The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [0, 104].
"""

# Definition for a Node.


class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution(object):
    #01
    def maxDepth(self, root: 'Node') -> int:
        """
        :type root: Node
        :rtype: int
        """
        if not root: return 0
        def f(root: 'Node'):
            if not root.children: return 1
            h = -1
            for v in root.children:
                h = max(h, f(v))
            return 1 + h
        return f(root)

if __name__ == "__main__":
    root = [1, None, 3, 2, 4, None, 5, 6]
    print("maxDepth({0}): {1}".format(
        root, Solution.maxDepth(Solution, root)))


# 01
# 38 / 38 test cases passed.
# Status: Accepted
# Runtime: 40 ms
# Memory Usage: 16.1 MB