"""
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1013/
Contains Duplicate III
Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 

Constraints:

0 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1

Hint #1  
Time complexity O(n logk) - This will give an indication that sorting is involved for k elements.
Hint #2  
Use already existing state to evaluate next state - Like, a set of k sorted numbers are only needed to be tracked. When we are processing the next number in array, then we can utilize the existing sorted state and it is not necessary to sort next overlapping set of k numbers again.
"""


from collections import OrderedDict

class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.height = 1


class AVLTree(object):
    def __init__(self):
        self.root = None
        self.size = 0
        
				
    def height(self, node):
        if node:
            return node.height
        return 0
    
		
    def setHeight(self, node):
        if node is None:
            return 0
        return 1 + max(self.height(node.left), self.height(node.right))
    
		
    def rightRotate(self, node):
        new_root = node.left
        node.left = node.left.right
        new_root.right = node
        node.height = self.setHeight(node)
        new_root.height = self.setHeight(new_root)
        return new_root
    
    
    def leftRotate(self, node):
        new_root = node.right
        node.right = node.right.left
        new_root.left = node
        node.height = self.setHeight(node)
        new_root.height = self.setHeight(new_root)
        return new_root
        
    
    def insert(self, node, val):
        if node == self.root:
            self.size += 1
        # Returns a Node pointing to updated subtree
        if node is None:
            return Node(val)
        if node.val < val:
            node.right = self.insert(node.right, val)
        else:
            node.left = self.insert(node.left, val)
        balance = self.height(node.left) - self.height(node.right)
        if balance > 1:
            if self.height(node.left.left) > self.height(node.left.right):
                node = self.rightRotate(node)
            else:
                node.left = self.leftRotate(node.left)
                node = self.rightRotate(node)
        elif balance < -1:
            if self.height(node.right.right) > self.height(node.right.left):
                node = self.leftRotate(node)
            else:
                node.right = self.rightRotate(node.right)
                node = self.leftRotate(node)
        else:
            node.height = self.setHeight(node)
        return node
    
    
    def getMinValNode(self, node):
        if node is None or node.left is None:
            return node
        return self.getMinValNode(node.left)
    
		
    def remove(self, node, val):
        if node is None:
            return None
        if node.val < val:
            node.right = self.remove(node.right, val)
        elif node.val > val:
            node.left = self.remove(node.left, val)
        else:
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            else:
                right_min_val_node = self.getMinValNode(node.right)
                node.val = right_min_val_node.val
                node.right = self.remove(node.right, right_min_val_node.val)
        
        node.height = self.setHeight(node)
        balance = self.height(node.left) - self.height(node.right)
        if balance > 1:
            if self.height(node.left.left) > self.height(node.left.right):
                node = self.rightRotate(node)
            else:
                node.left = self.leftRotate(node.left)
                node = self.rightRotate(node)
        elif balance < -1:
            if self.height(node.right.right) > self.height(node.right.left):
                node = self.leftRotate(node)
            else:
                node.right = self.rightRotate(node.right)
                node = self.leftRotate(node)
        else:
            node.height = self.setHeight(node)
        return node
    
    
    def predecessor(self, node, val):
        if node is None:
            return None
        if node.val == val:
            return val
        elif node.val > val:
            return self.predecessor(node.left, val)
        else:
            right_res = self.predecessor(node.right, val)
            return right_res if right_res else node.val    
            
						
    def successor(self, node, val):
        if node is None:
            return None
        if node.val == val:
            return val
        elif node.val < val:
            return self.successor(node.right, val)
        else:
            left_res = self.successor(node.left, val)
            return left_res if left_res else node.val
    

class Solution(object):
    #02
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        if k < 1 or t < 0:
            return False
        dic = Collection.OrderedDict()
        for n in nums:
            key = n if not t else n // t
            for m in (dic.get(key - 1), dic.get(key), dic.get(key + 1)):
                if m is not None and abs(n - m) <= t:
                    return True
            if len(dic) == k:
                dic.popitem(False)
            dic[key] = n
        return False

    #01
    def containsNearbyAlmostDuplicate1(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        avltree = AVLTree()
        root = avltree.root
        for i, num in enumerate(nums):            
            predecessor = avltree.predecessor(root, num)
            if predecessor is not None and abs(predecessor - num) <= t:
                return True
            successor = avltree.successor(root, num)
            if successor is not None and abs(successor - num) <= t:
                return True
                        
            root = avltree.insert(root, num)
            
            if avltree.size > k:
                root = avltree.remove(root, nums[i-k])
                
        return False


if __name__ == "__main__":
    nums = [1,2,3,1]
    k = 3
    t = 0
    print("containsNearbyAlmostDuplicate({0}, {1}, {2}): {3}".format(nums, k, t, Solution.containsNearbyAlmostDuplicate(Solution, nums, k, t)))

    nums = [1,0,1,1]
    k = 1
    t = 2
    print("containsNearbyAlmostDuplicate({0}, {1}, {2}): {3}".format(nums, k, t, Solution.containsNearbyAlmostDuplicate(Solution, nums, k, t)))

    nums = [1,5,9,1,5,9]
    k = 2
    t = 3
    print("containsNearbyAlmostDuplicate({0}, {1}, {2}): {3}".format(nums, k, t, Solution.containsNearbyAlmostDuplicate(Solution, nums, k, t)))

# 01
# 54 / 54 test cases passed.
# Status: Accepted
# Runtime: 1976 ms
# Memory Usage: 17.3 MB

# 02
# 54 / 54 test cases passed.
# Status: Accepted
# Runtime: 128 ms
# Memory Usage: 17.2 MB
