"""
https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2894/
Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
 
Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
"""

# Definition for a binary tree node.


from typing import Deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    #02
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p is None and q is None:
            return True
        elif p and q is None or q and p is None or p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    #01
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        def check(p, q):
            if not p and not q:
                return True
            if not p or not q:
                return False
            if p.val != q.val:
                return False
            return True

        deq = Deque([(p, q),])
        while deq:
            p, q = deq.popleft()

            if not check(p, q):
                return False

            if p:
                deq.append((p.left, q.left))
                deq.append((p.right, q.right))

        return True


if __name__ == "__main__":
    p = TreeNode()
    q = TreeNode()
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))

    p = TreeNode()
    q = TreeNode(1)
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))

    p = TreeNode(2)
    q = TreeNode()
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))

    p = TreeNode(4)
    q = TreeNode(3)
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))

    p = TreeNode(8)
    q = TreeNode(8)
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))

    p = TreeNode(8, left=TreeNode(7), right=TreeNode(10))
    q = TreeNode(8, left=TreeNode(7), right=TreeNode(10))
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))

    p = TreeNode(8, left=TreeNode(6), right=TreeNode(10))
    q = TreeNode(8, left=TreeNode(7), right=TreeNode(9))
    print("isSameTree({0}, {1}): {2}".format(
        p, q, Solution.isSameTree(Solution, p, q)))


# 01
# 60 / 60 test cases passed.
# Status: Accepted
# Runtime: 32 ms
# Memory Usage: 14.2 MB

# 02
# 60 / 60 test cases passed.
# Status: Accepted
# Runtime: 24 ms
# Memory Usage: 14.3 MB
