"""
https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1127/
Find Duplicate Subtrees

Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.

Example 1:
Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:
Input: root = [2,1,1]
Output: [[1]]
Example 3:
Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]

Constraints:
The number of the nodes in the tree will be in the range [1, 10^4]
-200 <= Node.val <= 200
"""


import collections
from typing import List


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution():
    # 02
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        memo = set()
        ans = []
        added = set()

        def postorder(root: TreeNode):
            if not root:
                return "e"

            left = postorder(root.left)
            right = postorder(root.right)

            cur = left + right + str(root.val)
            if cur in memo and cur not in added:
                ans.append(root)
                added.add(cur)
            else:
                memo.add(cur)
            return cur

        postorder(root)
        return ans

    # 01
    def findDuplicateSubtrees1(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        from hashlib import sha256

        def hash_(x):
            S = sha256()
            S.update(x)
            return S.hexdigest()

        def merkle(node):
            if not node:
                return '#'
            m_left = merkle(node.left)
            m_right = merkle(node.right)
            node.merkle = hash_(m_left + str(node.val) + m_right)
            count[node.merkle].append(node)
            return node.merkle

        count = collections.defaultdict(list)
        merkle(root)
        return [nodes.pop() for nodes in count.values() if len(nodes) >= 2]


if __name__ == "__main__":
    sol = Solution()

    root = [1, 2, 3, 4, None, 2, 4, None, None, 4]
    print(f"board:", root)
    print(f"findDuplicateSubtrees(board):", sol.findDuplicateSubtrees(root))

    root = [2, 1, 1]
    print(f"board:", root)
    print(f"findDuplicateSubtrees(board):", sol.findDuplicateSubtrees(root))

    root = [2, 2, 2, 3, None, 3, None]
    print(f"board:", root)
    print(f"findDuplicateSubtrees(board):", sol.findDuplicateSubtrees(root))

# 01
# 175 / 175 test cases passed.
# Status: Accepted
# Runtime: 72 ms
# Memory Usage: 19.3 MB
