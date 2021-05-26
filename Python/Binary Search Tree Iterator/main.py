"""
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Example 1:
Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False

Constraints:
The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next.

Follow up:
Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
"""

import collections

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#02
class BSTIterator(object):
    def __init__(self, root: TreeNode):
        self.nums = collections.deque()

        nodes = [root]
        while len(nodes) > 0:
            curr_node = TreeNode(nodes[-1])
            if curr_node.left:
                nodes.append(curr_node.left)
                curr_node.left = None
            else:
                nodes.pop()
                self.nums.append(curr_node.val)
                if curr_node.right is not None:
                    nodes.append(curr_node.right)
                    curr_node.right = None


    def next(self) -> int:
        return self.nums.popleft()


    def hasNext(self) -> bool:
        return len(self.nums) > 0


#01
class BSTIterator1(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.trav = root
        self.stack = []

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.trav or self.stack
        
    def next(self):
        """
        :rtype: int
        """
        while self.trav:
            self.stack.append(self.trav)
            self.trav = self.trav.left
        u = self.stack.pop()
        self.trav = u.right
        return u.val


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

if __name__ == "__main__":
    bSTIterator = BSTIterator([7, 3, 15, None, None, 9, 20])
    print(bSTIterator)



# 01
# 61 / 61 test cases passed.
# Status: Accepted
# Runtime: 72 ms
# Memory Usage: 20.5 MB
