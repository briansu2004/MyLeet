"""
https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2384/
Unique Binary Search Trees II

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 8
"""

# Definition for a binary tree node.


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    # 01
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        def helper(x, y):
            if x > y:
                return [None]
            if x == y:
                return [TreeNode(x)]

            ans = []
            for v in range(x, y+1):
                lans = helper(x, v-1)
                rans = helper(v+1, y)

                for l in lans:
                    for r in rans:
                        root = TreeNode(v)
                        root.left = l
                        root.right = r
                        ans.append(root)
            return ans
        return helper(1, n) if n >= 1 else []


if __name__ == "__main__":
    n = 1
    print("kthGrammar({0}) is: {1}".format(
        n, Solution.generateTrees(Solution, n)))


# 01
# 8 / 8 test cases passed.
# Status: Accepted
# Runtime: 40 ms
# Memory Usage: 16.6 MB
