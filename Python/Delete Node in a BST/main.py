"""
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1006/
Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?

Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
Example 2:
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:
Input: root = [], key = 0
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
"""

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return None
            
        if root.val > key:
		    # Target node is smaller than currnet node, search left subtree
            root.left = self.deleteNode( root.left, key )
        elif root.val < key:
		    # Target node is larger than currnet node, search right subtree
            root.right = self.deleteNode( root.right, key )
        else:
            # Current node is target node
            if (not root.left) or (not root.right):
                # At least one child is empty
                # Target node is replaced by either non-empty child or None
                root = root.left if root.left else root.right
            else:
                # Both two childs exist
                # Target node is replaced by smallest element of right subtree
                cur = root.right

                while cur.left:
                    cur = cur.left

                root.val = cur.val
                root.right = self.deleteNode( root.right, cur.val )      
        
        return root


if __name__ == "__main__":
    root = [5, 3, 6, 2, 4, None, 7]
    key = 0
    print("deleteNode({0}, {1}): {2}".format(
        root, key, Solution.deleteNode(Solution, root, key)))


# 01
# 91 / 91 test cases passed.
# Status: Accepted
# Runtime: 64 ms
# Memory Usage: 18.3 MB
